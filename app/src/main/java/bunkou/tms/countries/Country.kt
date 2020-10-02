package bunkou.tms.countries

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlin.random.Random


class Country(val name: String) {
    var Olives = MutableLiveData(0)
    var Grapes = MutableLiveData(0)
    var Peaches = MutableLiveData(0)


    suspend fun reapCrop() {
        while (Olives.value?.plus(Grapes.value ?: 0)?.plus(Peaches.value ?: 0) ?: 0 < 100) {
            Olives.postValue(Olives.value?.plus(Random.Default.nextInt(10)))
            Grapes.postValue(Grapes.value?.plus(Random.Default.nextInt(10)))
            Peaches.postValue(Peaches.value?.plus(Random.Default.nextInt(10)))
            delay((Random.Default.nextInt() % 2000).toLong())
        }
    }
}




