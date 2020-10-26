package bunkou.tms.HomeWork7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bunkou.tms.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_part_one.*

class Part_one : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_one)


        buttonСontinue.setOnClickListener {
            overrideAndStart()
        }

        button_start_animation.setOnClickListener {
            YoYo.with(Techniques.Pulse)
                .repeat(5)
                .duration(500)
                .onEnd {
                    overrideAndStart()
                }
                .playOn(textViewPaz1)
        }
    }


    private fun overrideAndStart() {
        startActivity(Intent(this, Part_two::class.java))
        overridePendingTransition(R.anim.enter_back, R.anim.exit_back)
    }
}
