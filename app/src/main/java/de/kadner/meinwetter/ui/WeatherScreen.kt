package de.kadner.meinwetter.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import de.kadner.meinwetter.R
import de.kadner.meinwetter.model.Info
import de.kadner.meinwetter.model.WeatherViewModel

@Composable
fun WeatherScreen( viewModel: WeatherViewModel )
{

    var city = remember { mutableStateOf( "" ) }
    var lastCity = remember { mutableStateOf( "" ) }

    val weatherData by viewModel.weatherData.observeAsState()

    Scaffold(

        topBar = { TopAppBar( title = { Text( text = stringResource( id = R.string.app_name ) ) } ) },

    )
    {

        it.calculateBottomPadding()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        )
        {

            OutlinedTextField(
                value = city.value,
                onValueChange = { city.value = it },
                label = { Text("Stadt eingeben") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, end = 8.dp)
            )

            Button(
                onClick = {
                    viewModel.getWeatherData(city.value)
                    lastCity.value = city.value
                    city.value = ""
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp, end = 16.dp)
            )
            {
                Text(text = "Wetter")
            }

            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.Start)
            )
            {

                var url = ""
                if (null != weatherData && null != weatherData?.info)
                {
                    var infos = weatherData?.info!!
                    url = "https://openweathermap.org/img/w/${infos[0].icon}.png"
                }

                AsyncImage(
                    model = url,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )

                Column(modifier = Modifier.padding(start = 16.dp))
                {

                    val temp = weatherData?.temp?.temp

                    //Log.d("TAG-X", "weatherData = ${weatherData?.info[0]}")

                    Text(
                        text = lastCity.value,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.h6
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = if (temp == null) "" else temp.toInt().toString() + "°C",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = weatherData?.info?.get(0)?.description?.toString() ?: "",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                }

            }

        }

    }

}