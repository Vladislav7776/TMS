package bunkou.tms.countries

import androidx.lifecycle.MutableLiveData

object ItalyCountry : Country {

    override val name = "Italy"
    override var Olives = MutableLiveData(0)
    override var Peaches = MutableLiveData(0)
    override var Grapes = MutableLiveData(0)

}