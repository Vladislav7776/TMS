package bunkou.tms.HomeWork9.network.dto


import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("data")
    val `data`: List<Data?>? = null,
    @SerializedName("status")
    val status: Status? = null
) {
    data class Data(
        @SerializedName("circulating_supply")
        val circulatingSupply: Double? = null,
        @SerializedName("cmc_rank")
        val cmcRank: Double? = null,
        @SerializedName("date_added")
        val dateAdded: String? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("last_updated")
        val lastUpdated: String? = null,
        @SerializedName("max_supply")
        val maxSupply: Double? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("num_market_pairs")
        val numMarketPairs: Double? = null,
        @SerializedName("platform")
        val platform: Any? = null,
        @SerializedName("quote")
        val quote: Quote? = null,
        @SerializedName("slug")
        val slug: String? = null,
        @SerializedName("symbol")
        val symbol: String? = null,
        @SerializedName("tags")
        val tags: List<String?>? = null,
        @SerializedName("total_supply")
        val totalSupply: Double? = null
    ) {
        data class Quote(
            @SerializedName("USD")
            val usd: USD? = null
        ) {
            data class USD(
                @SerializedName("last_updated")
                val lastUpdated: String? = null,
                @SerializedName("market_cap")
                val marketCap: Double? = null,
                @SerializedName("percent_change_1h")
                val percentChange1h: Double? = null,
                @SerializedName("percent_change_24h")
                val percentChange24h: Double? = null,
                @SerializedName("percent_change_7d")
                val percentChange7d: Double? = null,
                @SerializedName("price")
                val price: Double? = null,
                @SerializedName("volume_24h")
                val volume24h: Double? = null
            )
        }
    }

    data class Status(
        @SerializedName("credit_count")
        val creditCount: Double? = null,
        @SerializedName("elapsed")
        val elapsed: Double? = null,
        @SerializedName("error_code")
        val errorCode: Int? = null,
        @SerializedName("error_message")
        val errorMessage: Any? = null,
        @SerializedName("notice")
        val notice: Any? = null,
        @SerializedName("timestamp")
        val timestamp: String? = null,
        @SerializedName("total_count")
        val totalCount: Double? = null
    )
}