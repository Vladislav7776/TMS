package bunkou.tms.HomeWork14.mappers

import bunkou.tms.HomeWork14.entity.Country
import com.example.myapplicationrxjava.dto.SummaryResponse

object SummaryMapper {

    fun summaryMap(from: SummaryResponse.CountryResponse) = Country(
        flagUrl = "https://cdn.countryflags.com/thumbs/${
            from.country?.replace(" ", "-")?.toLowerCase()
        }/flag-800.png",
        countryName = from.country.orEmpty(),
        countryCode = from.countryCode.orEmpty(),
        date = from.date.orEmpty(),
        totalConfirmed = from.totalConfirmed ?: 0,
        totalDeaths = from.totalDeaths ?: 0,
        totalRecovered = from.totalRecovered ?: 0
    )
    }
