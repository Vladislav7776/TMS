package bunkou.tms.HomeWork7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bunkou.tms.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_mothers_day.*

class MothersDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mothers_day)

        button.setOnClickListener {
            overrideAndStart()
        }

        button_start_animation.setOnClickListener {

            YoYo.with(Techniques.Swing)
                .repeat(5)
                .duration(500)
                .onEnd {
                    overrideAndStart()
                }
                .playOn(hello_text)
        }
    }

    private fun overrideAndStart() {
        startActivity(Intent(this, Part_one::class.java))
        overridePendingTransition(R.anim.enter, R.anim.exit)
    }
}


