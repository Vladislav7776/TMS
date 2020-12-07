package bunkou.tms

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import bunkou.tms.HomeWork10.MainActivityNotification
import bunkou.tms.HomeWork11.MainWeather
import bunkou.tms.HomeWork11.WeatherAppWidgetConfigureActivity
import bunkou.tms.HomeWork12.MainLight
import bunkou.tms.HomeWork13.MainFibonacci
import bunkou.tms.HomeWork14.MainCovid
import bunkou.tms.HomeWork2.MainActivity2
import bunkou.tms.HomeWork3.MainActivity3
import bunkou.tms.HomeWork5.Coffe
import bunkou.tms.HomeWork4.Harvesting
import bunkou.tms.HomeWork6.MaterialActivity
import bunkou.tms.HomeWork7.MothersDayActivity
import bunkou.tms.HomeWork8.MainBake
import bunkou.tms.HomeWork9.MainRetrofitActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun homeWorkBtn(view: View) {
        val myIntent: Intent? = when (view.id) {
            R.id.button -> Intent(this, MainActivity2::class.java)
            R.id.button2 -> Intent(this, MainActivity3::class.java)
            R.id.button3 -> Intent(this, Harvesting::class.java)
            R.id.button4 -> Intent(this, Coffe::class.java)
            R.id.button5 -> Intent(this, MaterialActivity::class.java)
            R.id.button6 -> Intent(this, MothersDayActivity::class.java)
            R.id.button7 -> Intent(this, MainBake::class.java)
            R.id.button8 -> Intent(this, MainRetrofitActivity::class.java)
            R.id.button9 -> Intent(this, MainActivityNotification::class.java)
            R.id.button10 -> Intent(this, MainWeather::class.java)
            R.id.button11 -> Intent(this, MainLight::class.java)
            R.id.button12 -> Intent(this, MainFibonacci::class.java)
            R.id.button13 -> Intent(this, MainCovid::class.java)

            else -> null
        }
        if (myIntent != null) {
            startActivity(myIntent)
        }
    }
}