package bunkou.tms.countries

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlin.random.Random


interface Country {

    var Olives: MutableLiveData<Int>
    var Grapes: MutableLiveData<Int>
    var Peaches: MutableLiveData<Int>
    val name: String


    suspend fun reapCrop() {
        while (Olives.value?.plus(Grapes.value ?:0)?.plus(Peaches.value?:0)?:0 < 100){
            Olives.postValue( Olives.value?.plus(Random.Default.nextInt(10)))
            Grapes.postValue(Grapes.value?.plus(Random.Default.nextInt(10)))
            Peaches.postValue(Peaches.value?.plus(Random.Default.nextInt(10)))
            delay(1500)
        }

    }


}




