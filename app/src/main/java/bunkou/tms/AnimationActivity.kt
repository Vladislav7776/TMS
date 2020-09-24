package bunkou.tms

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
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