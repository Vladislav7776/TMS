package bunkou.tms.HomeWork11.mappers

import bunkou.tms.HomeWork11.dto.WeatherResponse
import bunkou.tms.HomeWork11.entity.CurrentWeather

object WeatherMapper {
    fun parse(from: WeatherResponse?) = CurrentWeather(
        description = from?.weather?.get(0)?.description.orEmpty(),
        iconId = from?.weather?.get(0)?.icon.orEmpty(),
        temp = from?.main?.temp ?: 0.0,
        cityName = from?.name.orEmpty()
    )
}


