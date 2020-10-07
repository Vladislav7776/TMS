package bunkou.tms.HomeWork6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bunkou.tms.R
import kotlinx.android.synthetic.main.activity_sign_in.*


private const val USER_NAME_KEY = "username"


class Activity_sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val text = intent.getStringExtra(USER_NAME_KEY)

        textViewFinish.text = "Welcome, $text"
    }
}