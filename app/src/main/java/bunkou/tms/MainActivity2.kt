package bunkou.tms

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    }

    fun onClick(view: View) {
        val url = editText.text.toString()
        if (url.isNotEmpty()) {

            val pic = Picasso.get()
            pic.isLoggingEnabled = true
            pic.load(url).into(imageView)
        }
    }
}