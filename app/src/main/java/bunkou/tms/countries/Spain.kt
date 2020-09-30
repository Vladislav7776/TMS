package bunkou.tms.countries

import androidx.lifecycle.MutableLiveData

object SpainCountry : Country {

    override val name = "Spain"
    override var Olives = MutableLiveData(0)
    override var Peaches = MutableLiveData(0)
    override var Grapes = MutableLiveData(0)

}