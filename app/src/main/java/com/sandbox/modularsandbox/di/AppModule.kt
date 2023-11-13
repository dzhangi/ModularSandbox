package com.sandbox.modularsandbox.di

import com.sandbox.modularsandbox.data.JokeApi
import com.sandbox.modularsandbox.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideTestString() = "Dumb string for testing di"

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): JokeApi = retrofit.create(JokeApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}