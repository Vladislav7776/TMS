package bunkou.tms.HomeWork9.network.networking

import bunkou.tms.HomeWork9.network.dto.CoinResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CoinApi {

    @GET("cryptocurrency/listings/latest")
    fun getCoin(): Deferred<Response<CoinResponse>>
}