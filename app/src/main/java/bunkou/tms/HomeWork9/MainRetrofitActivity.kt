package bunkou.tms.HomeWork9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Transformations.map
import androidx.recyclerview.widget.LinearLayoutManager
import bunkou.tms.HomeWork9.network.CoinAdapter
import bunkou.tms.HomeWork9.network.entity.Coin
import bunkou.tms.HomeWork9.network.mappers.CoinMapper
import bunkou.tms.HomeWork9.network.retrofit.RetrofitFactory
import bunkou.tms.R
import kotlinx.android.synthetic.main.mainretrofit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainRetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainretrofit)

        val retrofit = RetrofitFactory().getRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getCoin().await()
            if (response.isSuccessful) {
                val coinsResponse = response.body()
                val coins = coinsResponse?.data?.map {
                    it?.let { it1 -> CoinMapper.map(it1) }
                }
                withContext(Dispatchers.Main) {
                    val adapter = CoinAdapter(coins as List<Coin>)
                    retrofit_recycler.adapter = adapter
                    retrofit_recycler.layoutManager = LinearLayoutManager(this@MainRetrofitActivity)
                    retrofit_recycler.hasFixedSize()
                }
            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainRetrofitActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
