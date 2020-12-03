package bunkou.tms.HomeWork12

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bunkou.tms.R
import kotlinx.android.synthetic.main.activity_light.*


class MainLight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        sensorManager.registerListener(object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                val lightValue = event?.values?.get(0) ?: 0.0f
                light_text_tv.text = lightValue.toString()
                if (lightValue >= 300) {
                    illumination_background.setBackgroundColor(getColor(R.color.green))
                } else {
                    illumination_background.setBackgroundColor(getColor(R.color.red))
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

        }, lightSensor, 1)
    }
}