package bunkou.tms.HomeWork14

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bunkou.tms.HomeWork14.entity.Country
import bunkou.tms.HomeWork14.mappers.SummaryMapper
import bunkou.tms.HomeWork14.retrofit.CovidRetrofitFactory
import bunkou.tms.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Suppress("XZ")
class MainCovid : AppCompatActivity() {
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        compositeDisposable = CompositeDisposable()
        val retrofit = CovidRetrofitFactory.getInstance()

        val disposable = retrofit.getSummaryDataAsync()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { summaryResponse ->
                summaryResponse.countries?.map { countryResponse ->
                    SummaryMapper.summaryMap(countryResponse)
                }
            }
            .subscribe({ countries ->
                parseDate(countries?.get(0)?.date)
                countries?.let { initRecyclerView(countries) }
            }, { ex ->
                Log.e("TAG", ex.localizedMessage.toString())
            })
        compositeDisposable.add(disposable)
    }

    private fun initRecyclerView(countryList: List<Country>) {
        val covidAdapter = CovidAdapter()
        val covidRecyclerView = findViewById<RecyclerView>(R.id.covid_recycler_view)
        covidRecyclerView.apply {
            adapter = covidAdapter
            layoutManager = LinearLayoutManager(this@MainCovid)
        }
        covidAdapter.updateList(countryList)
    }

    @SuppressLint("SetTextI18n")
    private fun parseDate(date: String?) {
        val pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val newDate = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val formatter = DateTimeFormatter.ofPattern(pattern)
            val localDate = LocalDate.parse(date, formatter)
            "${localDate.dayOfMonth}:${localDate.monthValue}:${localDate.year}"
        } else {
            TODO()
        }

        val dateTV = findViewById<TextView>(R.id.date)
        dateTV.text = "Дата обновления: $newDate"
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }
}