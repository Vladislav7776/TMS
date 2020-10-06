package bunkou.tms.HomeWork4

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import bunkou.tms.R
import kotlinx.android.synthetic.main.activity_harvesting.*


class Harvesting : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harvesting)


        val viewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val layoutsToCountries = mapOf(
            Greece to viewModel.countries["GreeceCountry"],
            Italy to viewModel.countries["ItalyCountry"],
            Spain to viewModel.countries["SpainCountry"],

            )


        button_start.setOnClickListener {
            for ((layout, country) in layoutsToCountries) {
                setObserver(layout, country)
            }

            viewModel.winner.observe(this, Observer { winData ->
                Toast.makeText(this, "${winData.name} is winner", Toast.LENGTH_LONG).show()
            })
            button_start.isEnabled = false
            button_start.visibility = View.GONE
            viewModel.findWinnerInReapingCrop()
        }
    }

    private fun setObserver(layout: LinearLayout, country: Country?) {
        for (textView in layout.children) {
            textView as TextView

            when (textView.text.toString().substringBefore(" ")) {
                "Olives" -> country?.Olives?.observe(this, Observer { OlivesData ->
                    textView.text = "Olives - $OlivesData"
                })
                "Grapes" -> country?.Grapes?.observe(this, Observer { GrapesData ->
                    textView.text = "Grapes - $GrapesData"
                })
                "Peaches" -> country?.Peaches?.observe(this, Observer { PeachesData ->
                    textView.text = "Peaches - $PeachesData"
                })

            }
        }
    }
}





