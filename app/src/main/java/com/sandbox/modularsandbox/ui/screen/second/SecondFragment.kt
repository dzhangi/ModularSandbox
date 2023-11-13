package com.sandbox.modularsandbox.ui.screen.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class SecondFragment : Fragment() {
    private val args by navArgs<SecondFragmentArgs>()
    private val viewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // requireActivity() needs to make @AndroidEntryPoint works
        return ComposeView(requireActivity()).apply {
            setContent {
                SecondScreen(
                    viewModel = viewModel,
                    navController = findNavController(),
                    args = args
                )
            }
        }
    }
}