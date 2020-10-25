package bunkou.tms.HomeWork8

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bunkou.tms.HomeWork8.entity.Bake
import bunkou.tms.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_bake.view.*

class BakeAdapter(private val BakeSet: List<Bake>) :
    RecyclerView.Adapter<BakeAdapter.BakeViewHolder>() {

    class BakeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bake, parent, false)

        return BakeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return BakeSet.size
    }

    override fun onBindViewHolder(holder: BakeViewHolder, position: Int) {

        val item = BakeSet[position]

        holder.itemView.BakeName.text = item.name
        holder.itemView.BakemaxSpeed.text = item.maxSpeed.toString()
        holder.itemView.Bakeprice.text = item.price.toString()
        holder.itemView.Bakeweight.text = item.weight.toString()

        Glide.with(holder.itemView.context).load(item.photoUrl).into(holder.itemView.photo)

        holder.itemView.cardView.setOnClickListener {
            Toast.makeText(holder.itemView.context, item.name, Toast.LENGTH_SHORT).show()
        }

    }



}