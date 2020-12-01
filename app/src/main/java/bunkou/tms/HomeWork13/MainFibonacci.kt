package bunkou.tms.HomeWork13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import bunkou.tms.R

class MainFibonacci : AppCompatActivity() {

    private lateinit var numberEt: EditText
    private lateinit var resultTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fibonacci)

        numberEt = findViewById(R.id.fibonacci_number_et)
        resultTv = findViewById(R.id.fibonacci_result_tv)
    }

    fun onClick(view: View) {
        if (!numberEt.text.isNullOrEmpty()) {
            val n = numberEt.text.toString().toLong()
            val fibNumber = Fibonacci().fibCalc(n)
            resultTv.text = fibNumber.toString()
        }
    }
}
