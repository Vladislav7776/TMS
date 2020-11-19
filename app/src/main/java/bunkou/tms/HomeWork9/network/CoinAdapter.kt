package bunkou.tms.HomeWork9.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import bunkou.tms.HomeWork9.network.entity.Coin
import bunkou.tms.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin.view.*

private const val URL_IMAGE = "https://s2.coinmarketcap.com/static/img/coins/64x64/"

class CoinAdapter(
    private var coinSet: List<Coin>
) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coin, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinAdapter.ViewHolder, position: Int) {

        with(holder.itemView) {
            val item = coinSet[position]
            name.text = item.name

            if (item.price!!.toDouble() < 1) {
            price.text = "$" + String.format("%.6f", item.price)
        } else {
            price.text = "$" + String.format("%.2f", item.price)
        }

            percentChange.text = "1 hours: "   + String.format("%.2f", item.percentChange) + "%"

            var color = getColor(context, R.color.green)
            if (item.percentChange!! < 0) {
                color = getColor(context, R.color.red)
            }
            percentChange.setTextColor(color)
            val logoURl: ImageView = imageView
            Picasso.get().load(URL_IMAGE + item.id.toString() + ".png").into(logoURl)
        }
    }

    override fun getItemCount(): Int {
        return coinSet.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}

