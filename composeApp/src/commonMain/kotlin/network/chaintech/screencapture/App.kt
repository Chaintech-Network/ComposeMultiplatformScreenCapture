package network.chaintech.screencapture

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import composemultiplatformscreencapture.composeapp.generated.resources.Res
import composemultiplatformscreencapture.composeapp.generated.resources.qr_code
import network.chaintech.composeMultiplatformScreenCapture.ScreenCaptureComposable
import network.chaintech.composeMultiplatformScreenCapture.rememberScreenCaptureController
import network.chaintech.screencapture.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun App() = AppTheme {
    PaymentReceived()
}

@Composable
fun PaymentReceived() {
    val captureController = rememberScreenCaptureController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF004DEF))
    ) {
        Row(
            modifier = Modifier.padding(top = 20.dp).statusBarsPadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                Icons.Filled.Share,
                "Share",
                modifier = Modifier.padding(end = 12.dp).size(28.dp)
                    .clickable { captureController.capture() },
                tint = Color.White
            )
        }

        ScreenCaptureComposable(
            modifier = Modifier,
            screenCaptureController = captureController,
            shareImage = true,
            onCaptured = { img, throwable ->

            }
        ) {
            AppTheme {
                Column(modifier = Modifier.background(Color.White)) {
                    PaymentReceivedView()
                }
            }
        }
    }
}

@Composable
fun ColumnScope.PaymentReceivedView() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.height(200.dp).fillMaxWidth().background(Color(0xFF004DEF))) {
            Text(
                text = "Invoice",
                style = TextStyle(fontSize = 20.sp, color = Color.White),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 18.dp).align(Alignment.TopCenter)
            )
        }
        Card(
            modifier = Modifier
                .padding(top = 96.dp, start = 16.dp, end = 16.dp, bottom = 30.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(6.dp),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Money Transfer",
                    style = TextStyle(fontSize = 20.sp, color = Color.Black),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 50.dp).align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Powered by MobiKwik",
                    style = TextStyle(fontSize = 20.sp, color = Color.Black),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 4.dp).align(Alignment.CenterHorizontally)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 16.dp)
                        .background(Color(0xFFF7F7F7), RoundedCornerShape(8.dp))
                        .padding(bottom = 10.dp).align(Alignment.CenterHorizontally),
                ) {
                    Text(
                        text = "Order ID: OMK25e9ef4ed5005544",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                        modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp)
                    )

                    DashedLine(modifier = Modifier.padding(top = 10.dp).height(2.dp).fillMaxWidth())

                    Text(
                        text = "UPI Transaction ID: 4320692331397",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                        modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp)
                    )
                }
                Text(
                    text = "Fri, 04 Feb 2024, 8:12 pm",
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding(top = 66.dp)
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(Color.White),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                        .border(2.dp, Color(0xFF004DEF), CircleShape)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        Icons.Filled.Done,
                        "Share",
                        modifier = Modifier.size(36.dp).align(Alignment.Center),
                        tint = Color.Green
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier.background(Color(0xFFE6EBE5))
            .padding(horizontal = 14.dp, vertical = 18.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Total Amount Paid",
                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(1.dp).weight(1f))
            Text(
                text = "₹395",
                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }
        Text(
            text = "Paid from UPI: ₹395",
            style = TextStyle(fontSize = 14.sp, color = Color.Gray),
            modifier = Modifier.padding(top = 8.dp)
        )
    }

    Text(
        text = "Billed To",
        style = TextStyle(fontSize = 16.sp, color = Color.Black),
        modifier = Modifier.padding(top = 20.dp, start = 14.dp, end = 14.dp)
    )

    Row(modifier = Modifier.padding(top = 8.dp, start = 14.dp, end = 14.dp).fillMaxWidth()) {
        Text(
            text = "Name",
            style = TextStyle(fontSize = 16.sp, color = Color.Gray),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(1.dp).weight(1f))
        Text(
            text = "Robert Jhon Castillo",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
        )
    }
    Row(modifier = Modifier.padding(top = 8.dp, start = 14.dp, end = 14.dp).fillMaxWidth()) {
        Text(
            text = "Mobile No.",
            style = TextStyle(fontSize = 16.sp, color = Color.Gray),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(1.dp).weight(1f))
        Text(
            text = "7896554456",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
        )
    }
    Row(modifier = Modifier.padding(top = 8.dp, start = 14.dp, end = 14.dp).fillMaxWidth()) {
        Text(
            text = "VPA",
            style = TextStyle(fontSize = 16.sp, color = Color.Gray),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(1.dp).weight(1f))
        Text(
            text = "7896554456@ikwik",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
        )
    }

    Text(
        text = "Received By",
        style = TextStyle(fontSize = 16.sp, color = Color.Black),
        modifier = Modifier.padding(top = 20.dp, start = 14.dp, end = 14.dp)
    )

    Row(modifier = Modifier.padding(top = 8.dp, start = 14.dp, end = 14.dp).fillMaxWidth()) {
        Text(
            text = "Name",
            style = TextStyle(fontSize = 16.sp, color = Color.Gray),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(1.dp).weight(1f))
        Text(
            text = "Robert Jhon Castillo",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
        )
    }
    Row(modifier = Modifier.padding(top = 8.dp, start = 14.dp, end = 14.dp).fillMaxWidth()) {
        Text(
            text = "Mobile No.",
            style = TextStyle(fontSize = 16.sp, color = Color.Gray),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(1.dp).weight(1f))
        Text(
            text = "NA",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
        )
    }
    Row(modifier = Modifier.padding(top = 8.dp, start = 14.dp, end = 14.dp).fillMaxWidth()) {
        Text(
            text = "VPA",
            style = TextStyle(fontSize = 16.sp, color = Color.Gray),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(1.dp).weight(1f))
        Text(
            text = "paytm-jiomobility@paytm",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
        )
    }
    Image(
        modifier = Modifier
            .padding(top = 26.dp, bottom = 40.dp)
            .size(90.dp)
            .align(Alignment.CenterHorizontally),
        painter = painterResource(Res.drawable.qr_code),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun DashedLine(modifier: Modifier) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(modifier) {

        drawLine(
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}