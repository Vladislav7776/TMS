package bunkou.tms.HomeWork8

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import bunkou.tms.HomeWork8.dao.Bakedao
import bunkou.tms.HomeWork8.entity.Bake
import bunkou.tms.HomeWork8.utils.launchForResult
import bunkou.tms.HomeWork8.utils.launchIo
import bunkou.tms.HomeWork8.utils.launchUi
import bunkou.tms.R
import kotlinx.android.synthetic.main.recycler_layout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_layout)
        val db: Bakedao = Db.getDB(this).bakedao()

        launchIo {
            val list: List<Bake> = db.allbake_table()

            val bakeAdapter = BakeAdapter(list)

            withContext(Dispatchers.Main) {
                bakeRecycler.layoutManager = LinearLayoutManager(this@RecyclerActivity)
                bakeRecycler.setHasFixedSize(true)
                bakeRecycler.adapter = bakeAdapter
            }
        }

        add_bake.setOnClickListener {
            startActivity(Intent(this, MainBake::class.java))
        }

    }
}