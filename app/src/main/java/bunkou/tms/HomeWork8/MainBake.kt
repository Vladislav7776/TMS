package bunkou.tms.HomeWork8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import bunkou.tms.HomeWork8.dao.Bakedao
import bunkou.tms.HomeWork8.entity.Bake
import bunkou.tms.HomeWork8.utils.launchForResult
import bunkou.tms.HomeWork8.utils.launchIo
import bunkou.tms.HomeWork8.utils.launchUi
import bunkou.tms.R
import kotlinx.android.synthetic.main.activity_bake.*
import kotlinx.android.synthetic.main.activity_bake.view.*
import kotlinx.android.synthetic.main.recycler_layout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainBake : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bake)

        val db: Bakedao = Db.getDB(applicationContext).bakedao()

        btn_put.setOnClickListener {

            val name = text_name.text.toString()
            val maxSpeed = text_Speed.text.toString().toInt()
            val weight = text_weight.text.toString().toDouble()
            val price = text_price.text.toString().toDouble()
            val photoUrl = text_number_photoUrl.text.toString()

            val bake = Bake(name, maxSpeed, weight, price, photoUrl)

            launchIo {
                db.addBake(bake)
            }
        }

        btn_read.setOnClickListener {

            startActivity(Intent(this, RecyclerActivity::class.java))
        }

        btn_clear.setOnClickListener {
            launchIo {
                db.clearDatabase()
            }
        }
    }
}




