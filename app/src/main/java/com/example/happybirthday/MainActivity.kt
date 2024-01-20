package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    GreetingImage(getString(R.string.happy_birthday_text),
                        getString(R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 66.sp,
            textAlign = TextAlign.Center,

        )
        Text(
            text = from,
            fontSize = 20.sp,
            // Modifiers are used to decorate or add behavior to Jetpack Compose UI elements. For example, you can add backgrounds, padding or behavior to rows, text, or buttons. To set them, a composable or a layout needs to accept a modifier as a parameter.
            modifier = Modifier
                .padding(16.dp)
                // align the text at the center of line
                .align(alignment = Alignment.CenterHorizontally)

            )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    // Box work as a stack
    Box {
        Image(
            // show image
            painter = image,
            // content on the image becomes null
            contentDescription = null,
            // set image according to screen
            contentScale = ContentScale.Crop,
            // set the opacity level between 0 and 1
            alpha = 0.5F
        )
        // After this when we add Text it will shown on above the image
        GreetingText(
            message = message,
            from = from ,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(stringResource(R.string.happy_birthday_text) , stringResource(R.string.signature_text))
    }
}