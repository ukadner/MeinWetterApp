package de.kadner.meinwetter.model

import com.google.gson.annotations.SerializedName

class WeatherData (
    @SerializedName( "name" ) val city: String,
    @SerializedName( "main" ) val temp: Temp,
    @SerializedName( "weather" ) val info: Array<Info>
)

class Info ( val description: String, val icon: String )

class Temp ( var temp: Double )
