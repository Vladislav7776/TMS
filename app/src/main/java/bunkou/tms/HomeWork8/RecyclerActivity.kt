package bunkou.tms.HomeWork8

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import bunkou.tms.HomeWork8.dao.Bakedao
import bunkou.tms.HomeWork8.entity.Bake
import bunkou.tms.R
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.recycler_layout.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_layout)


//        val adapter = BakeAdapter(Db.getDB())
//        bakeRecycler.adapter = adapter
//        bakeRecycler.layoutManager = LinearLayoutManager(this)
//        bakeRecycler.hasFixedSize()


    }
}