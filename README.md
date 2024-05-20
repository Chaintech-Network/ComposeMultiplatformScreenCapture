# ScreenCapture

ScreenCapture is a Compose Multiplatform library for capturing screens in your Android or iOS App.

![Hero-image - Screen Capture (2)](https://github.com/ChainTechNetwork/ComposeMultiplatformScreenCapture/assets/143475887/e3332273-983c-4c87-8258-716ae8f93fb6)


## Installation

Add the dependency to your `build.gradle.kts` file:

```
commonMain.dependencies {
    implementation("network.chaintech:compose-multiplatform-screen-capture:1.0.1")
}
```

## Usage

![screen_capture_demo](https://github.com/ChainTechNetwork/ComposeMultiplatformScreenCapture/assets/143475887/69d08028-49b1-4586-a264-8203257e7f93)


### Android
- Include this in your AndroidManifest.xml:

```
<provider
    android:name="androidx.core.content.FileProvider"
    android:authorities="network.chaintech.cmp.screenshot.fileprovider"
    android:exported="false"
    android:grantUriPermissions="true">
    <meta-data
        android:name="android.support.FILE_PROVIDER_PATHS"
        android:resource="@xml/file_paths" />
</provider>
```

- Create file_paths.xml in androidMain->res->xml and add the following code:

```
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <files-path
        name="screen_shots"
        path="share_images" />
    <external-path
        name="external_files"
        path="." />
</paths>
```

- Add the following line in onCreate of your Activity class:

```
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ...
        AppContext.apply { set(this@AppActivity) }
        ...
    }
}
```

### Composable Usage
  
```kotlin
val captureController = rememberScreenCaptureController()

ScreenCaptureComposable(
    modifier = Modifier,
    screenCaptureController = captureController,
    shareImage = true,
    onCaptured = { img, throwable ->

    }
) {
    AppTheme {
        content() // place your composable content here
    }
}
```


### Capture Image Example

```kotlin
ElevatedButton(
    modifier = Modifier
        .padding(top = 40.dp)
        .widthIn(min = 200.dp).align(Alignment.CenterHorizontally),
    onClick = {
        captureController.capture()
    },
    content = {
        Text(
            "Preview ScreenShot",
            style = TextStyle(fontSize = 16.sp),
            fontWeight = FontWeight.Bold
        )
    },
    colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Cyan),
)
```

### Explanation

* `modifier`: Modifier for modifying the layout of the screen capture component.
* `screenCaptureController`: Controller for managing the screen capture functionality.
* `shareImage`: Boolean indicating whether the user intends to share the captured image.
* `onCaptured`: Callback invoked when an image is successfully captured or when there's a failure during the capture process. It provides an ImageBitmap representing the captured image and a Throwable in case of any errors.
* `content`: A composable function that defines the content to be displayed within the screen capture component. This could include buttons, text, or any other UI elements related to screen capture functionality.

- For More [Follow This Class](https://github.com/ChainTechNetwork/ComposeMultiplatformScreenCapture/blob/main/composeApp/src/commonMain/kotlin/network/chaintech/screencapture/App.kt) 
- Follow [Medium Link](https://medium.com/mobile-innovation-network/screencapture-compose-multiplatform-kmp-5aef62dd0dcf) for example
- Follow [LinkedIn For More Updates](https://www.linkedin.com/showcase/mobile-innovation-network)


