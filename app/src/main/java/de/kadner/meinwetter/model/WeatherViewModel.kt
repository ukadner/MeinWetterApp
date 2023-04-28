package de.kadner.meinwetter.model

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.kadner.meinwetter.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel( val app: Context ) : ViewModel()
{

    val _weatherData = MutableLiveData<WeatherData>()
    val _weatherImage = MutableLiveData<Bitmap>()

    val weatherRepository = WeatherRepository( app )
    val weatherData: LiveData<WeatherData> = _weatherData
    val weatherImage: LiveData<Bitmap> = _weatherImage


    fun getWeatherData( city: String )
    {

        viewModelScope.launch()
        {
            _weatherData.value = weatherRepository.getWeather( city )
            val t = _weatherData.value?.temp?.temp
            if ( null != t )
            {
                _weatherData.value?.temp?.temp = t - 273.15
            }

        }

    }

    fun getImage()
    {

        viewModelScope.launch()
        {
            weatherRepository.getImage( _weatherImage, weatherData.value!! )
        }

    }

}