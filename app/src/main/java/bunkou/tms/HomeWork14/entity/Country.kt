package bunkou.tms.HomeWork14.entity

data class Country(
    val flagUrl: String,
    val countryName: String,
    val countryCode: String,
    val date: String,
    val totalConfirmed: Int,
    val totalDeaths: Int,
    val totalRecovered: Int
)