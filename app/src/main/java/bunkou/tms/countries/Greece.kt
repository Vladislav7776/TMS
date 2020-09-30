package bunkou.tms.countries

import androidx.lifecycle.MutableLiveData

  object GreeceCountry : Country {

    override val name = "Greece"
    override var Olives = MutableLiveData(0)
    override var Fig = MutableLiveData(0)
    override var Peaches = MutableLiveData(0)
    override var Grapes = MutableLiveData(0)
    override var Orange = MutableLiveData(0)
    override var Tomato = MutableLiveData(0)


}