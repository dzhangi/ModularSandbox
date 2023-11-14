//package com.sandbox.modularsandbox.ui.screen.splash
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.ComposeView
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import com.sandbox.modularsandbox.ui.theme.ModularSandboxTheme
//import dagger.hilt.android.AndroidEntryPoint
//
///**
// * A simple [Fragment] subclass as the default destination in the navigation.
// */
//@AndroidEntryPoint
//class SplashFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        // requireActivity() needs to make @AndroidEntryPoint works
//        return ComposeView(requireActivity()).apply {
//            setContent {
//                ModularSandboxTheme {
//                    Surface {
//                        SimpleButton(text = "Go to second fragment") {
//                            val action =
//                                SplashFragmentDirections.actionSplashFragmentToSecondFragment(234)
//                            findNavController().navigate(action)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun SimpleButton(
//    text: String,
//    enabled: Boolean = true,
//    onClick: () -> Unit,
//) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier.wrapContentSize(),
//        enabled = enabled,
//    ) {
//        Text(text = text)
//    }
//}