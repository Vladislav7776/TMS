package bunkou.tms.countries

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlin.random.Random


interface Country {


    var Olives: MutableLiveData<Int>
    var Grapes: MutableLiveData<Int>
    var Orange: MutableLiveData<Int>
    var Fig: MutableLiveData<Int>
    var Peaches: MutableLiveData<Int>
    var Tomato: MutableLiveData<Int>
    val name: String

    suspend fun CropGreece() {
        while (Olives.value?.plus(Fig.value ?: 0)?.plus(Peaches.value ?: 0) ?: 0 < 100) {
            Olives.postValue(Olives.value?.plus(Random.Default.nextInt(10)))
            Fig.postValue(Fig.value?.plus(Random.Default.nextInt(10)))
            Peaches.postValue(Peaches.value?.plus(Random.Default.nextInt(10)))
            delay(1500)
        }
    }

    suspend fun CropItaly() {
        while (Olives.value?.plus(Grapes.value ?: 0)?.plus(Orange.value ?: 0) ?: 0 < 100) {
            Olives.postValue(Olives.value?.plus(Random.Default.nextInt(10)))
            Grapes.postValue(Grapes.value?.plus(Random.Default.nextInt(10)))
            Orange.postValue(Orange.value?.plus(Random.Default.nextInt(10)))
            delay(1500)
        }
    }

    suspend fun CropSpain() {
        while (Tomato.value?.plus(Grapes.value ?: 0)?.plus(Peaches.value ?: 0) ?: 0 < 100) {
            Tomato.postValue(Tomato.value?.plus(Random.Default.nextInt(10)))
            Grapes.postValue(Grapes.value?.plus(Random.Default.nextInt(10)))
            Peaches.postValue(Peaches.value?.plus(Random.Default.nextInt(10)))
            delay(1500)
        }

    }
}




