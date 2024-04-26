import androidx.compose.ui.window.ComposeUIViewController
import network.chaintech.screencapture.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
