package bunkou.tms

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import bunkou.tms.HomeWork2.MainActivity2
import bunkou.tms.HomeWork3.MainActivity3
import bunkou.tms.HomeWork5.Coffe
import bunkou.tms.HomeWork4.Harvesting
import bunkou.tms.HomeWork6.MaterialActivity
import bunkou.tms.HomeWork7.MothersDayActivity
import bunkou.tms.HomeWork8.MainBake

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
            else -> null
        }
        if (myIntent != null) {
            startActivity(myIntent)
        }
    }
}