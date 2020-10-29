package bunkou.tms.HomeWork8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bunkou.tms.HomeWork8.entity.Bake
import bunkou.tms.R
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bake.view.*

class BakeAdapter(private val bakeSet: List<Bake>) :
    RecyclerView.Adapter<BakeAdapter.BakeViewHolder>() {

    class BakeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bake, parent, false)

        return BakeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bakeSet.size
    }

    override fun onBindViewHolder(holder: BakeViewHolder, position: Int) {

        val item = bakeSet[position]

        holder.itemView.BakeName.text = item.name
        holder.itemView.BakemaxSpeed.text = "${item.maxSpeed} км/ч "
        holder.itemView.Bakeprice.text = "${item.price} рублей"
        holder.itemView.Bakeweight.text = "${item.weight} кг "

        Glide.with(holder.itemView.context).load(item.photoUrl).into(holder.itemView.photo)

        holder.itemView.cardView.setOnClickListener {
            Toast.makeText(holder.itemView.context, item.name, Toast.LENGTH_SHORT).show()
        }

    }
}