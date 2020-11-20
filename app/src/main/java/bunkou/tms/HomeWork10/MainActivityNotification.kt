package bunkou.tms.HomeWork10

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import bunkou.tms.R

const val DURATION = "duration"

class MainActivityNotification : AppCompatActivity() {
    private lateinit var timePicker: TimePicker

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_notification)

        val buttonStart = findViewById<Button>(R.id.button_start_notification)
        timePicker = findViewById(R.id.timePicker_notification)
        timePicker.setIs24HourView(true)
        timePicker.minute = 0
        timePicker.hour = 0

        val intent = Intent(this, TimerService::class.java)

        buttonStart.setOnClickListener {
            val duration = timePicker.hour * 60 + timePicker.minute
            intent.putExtra(DURATION, duration)
            startService(intent)
        }
    }
}