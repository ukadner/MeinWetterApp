package de.kadner.meinwetter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.kadner.meinwetter.model.WeatherViewModel
import de.kadner.meinwetter.ui.WeatherScreen
import de.kadner.meinwetter.ui.theme.MeinWetterTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            MeinWetterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    WeatherScreen( WeatherViewModel( this ) )
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)


@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    MeinWetterTheme {
        WeatherScreen( WeatherViewModel( MainActivity() ) )
    }
}