package bunkou.tms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bunkou.tms.HomeWork2.MainActivity2
import bunkou.tms.HomeWork3.MainActivity3
import bunkou.tms.HomeWork5.Coffe
import bunkou.tms.HomeWork4.Harvesting
import bunkou.tms.HomeWork6.MaterialActivity
import bunkou.tms.HomeWork7.MothersDayActivity
import bunkou.tms.HomeWork8.MainBake
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {

            val myIntent = Intent(this, MainActivity2::class.java) // намерение
            startActivity(myIntent)
        }
        button2.setOnClickListener {

            val myIntent = Intent(this, MainActivity3::class.java) // намерение
            startActivity(myIntent)
        }

        button3.setOnClickListener {
            val myIntent = Intent(this, Harvesting::class.java)
            startActivity(myIntent)
        }

        button4.setOnClickListener {

            val myIntent = Intent(this, Coffe::class.java)
            startActivity(myIntent)
        }
        button5.setOnClickListener {
            val myIntent = Intent(this, MaterialActivity::class.java)
            startActivity(myIntent)
        }
        button6.setOnClickListener {
            val myIntent = Intent(this, MothersDayActivity::class.java)
            startActivity(myIntent)
        }

        button7.setOnClickListener {
            val myIntent = Intent(this, MainBake::class.java)
            startActivity(myIntent)
        }

    }
}