package bunkou.tms

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bunkou.tms.countries.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val countries = arrayListOf(GreeceCountry, ItalyCountry, SpainCountry)

    @Volatile
    var win = MutableLiveData<Country>()

    fun Win_In_Crop() {
        for (country in countries) {
            CoroutineScope(Dispatchers.IO).launch {
                country.reapCrop()
            }.invokeOnCompletion {
                if (win.value == null) {
                    win.postValue(country)
                }
            }
        }
    }
}