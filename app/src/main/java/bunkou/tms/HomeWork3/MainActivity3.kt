package bunkou.tms.HomeWork3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bunkou.tms.R
import kotlinx.android.synthetic.main.flags_and_animation.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flags_and_animation)

        buttonFlags.setOnClickListener {
            val myIntent = Intent(this, FlagActivity::class.java)
            startActivity(myIntent)
        }

        buttonAnimation.setOnClickListener {
            val myIntent = Intent(this, AnimationActivity::class.java)
            startActivity(myIntent)
        }


    }
}
