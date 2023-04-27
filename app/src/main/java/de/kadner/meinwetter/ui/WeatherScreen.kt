package de.kadner.meinwetter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.kadner.meinwetter.R

@Composable
fun WeatherScreen()
{

    var city = remember { mutableStateOf( "" ) }

    Column( modifier = Modifier.fillMaxSize().padding( horizontal = 16.dp ) )
    {

        OutlinedTextField(
            value = city.value,
            onValueChange = { city.value= it },
            label = { Text("Stadt eingeben") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 8.dp)
        )

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp, end = 16.dp)
        ) {
            Text(text = "Wetter")
        }

        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.Start)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "TextView",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "TextView",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}