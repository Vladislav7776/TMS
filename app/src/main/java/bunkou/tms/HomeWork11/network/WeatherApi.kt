package bunkou.tms.HomeWork11.network

import bunkou.tms.HomeWork11.dto.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    fun getWeatherInfoAsync(
        @Query("q") q: String,   //Название города, код штата и код страны, разделенные запятой
        @Query("appid") api: String = "bd1962a1ae7f70ced1334772badc1686",
        @Query("lang") lang: String = "ru",  // получить вывод на вашем языке
        @Query("units") units: String = "metric" //Меры измерения
    ): Deferred<Response<WeatherResponse>>

}