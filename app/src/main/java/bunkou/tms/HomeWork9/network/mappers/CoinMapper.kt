package bunkou.tms.HomeWork9.network.mappers

import bunkou.tms.HomeWork9.network.dto.CoinResponse
import bunkou.tms.HomeWork9.network.entity.Coin

object CoinMapper {

    fun map(from: CoinResponse.Data): Coin {

        return Coin(
            id = from.id ?: 0,
            price = from.quote?.usd?.price ?: 0.0,
            name = from.name.orEmpty(),
            percentChange = from.quote?.usd?.percentChange1h ?: 0.0
        )
    }
}