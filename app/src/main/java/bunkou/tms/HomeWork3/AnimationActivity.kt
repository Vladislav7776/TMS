package bunkou.tms.HomeWork3

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bunkou.tms.R
import kotlinx.android.synthetic.main.animation.*

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation)

        imageCat.setBackgroundResource(R.drawable.cat_animation)
        val animation = imageCat.background as AnimationDrawable

        buttonStart.setOnClickListener {
            animation.start()
        }
        buttonStop.setOnClickListener {
            animation.stop()
        }

    }
}