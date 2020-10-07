package bunkou.tms.HomeWork6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import bunkou.tms.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_material.*

private const val USER_NAME_KEY = "username"

class MaterialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)

        var login = false
        var password = false

        materialEditText.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                materialEditText.isEnabled = true
                materialTextField.error = "Name must not be empty"
                login = false
            } else {
                login = true
                materialTextField.error = null
            }
        }


        materialPassword.addTextChangedListener {
            when {
                it.isNullOrEmpty() -> {
                    materialPassword.isEnabled = true
                    materialPassword.error = "Password must not be empty!"
                    password = false
                }
                it.length in 1..7 -> {
                    materialPassword.isEnabled = true
                    materialPassword.error = "Password must be more then 8 symbols!"
                    password = false
                }
                else -> {
                    materialPassword.error = null
                    password = true
                }
            }
        }

        ButtonRegister.setOnClickListener {
            if (password && login) {
                successSign()
            } else {
                unsuccessSign()
            }
        }
    }


    private fun successSign() {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.setTitle))
            .setIcon(getDrawable(R.drawable.login))
            .setMessage(resources.getString(R.string.successSign))
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                intent = Intent(this, Activity_sign_in::class.java)
                intent.putExtra(USER_NAME_KEY, materialEditText.text.toString())
                startActivity(intent)
            }
            .show()
    }

    private fun unsuccessSign() {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.setTitle2))
            .setIcon(getDrawable(R.drawable.login))
            .setMessage(resources.getString(R.string.unsuccessSign))
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}
