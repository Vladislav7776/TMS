package bunkou.tms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val myIntent = Intent(this,Harvesting::class.java)
            startActivity(myIntent)
        }

    }
}