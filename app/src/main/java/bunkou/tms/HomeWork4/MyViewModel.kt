package bunkou.tms.HomeWork4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val countries = mapOf(
        "Greece" to Country("Greece"),
        "Spain" to Country("Spain"),
        "Italy" to Country("Italy")
    )

    @Volatile
    var winner = MutableLiveData<Country>()

    fun findWinnerInReapingCrop() {
        for (country in countries.values) {
            CoroutineScope(Dispatchers.IO).launch {
                country.reapCrop()
            }.invokeOnCompletion {

                if (winner.value == null) {
                    winner.postValue(country)
                }
            }

        }
    }
}
