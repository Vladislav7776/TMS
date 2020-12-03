package bunkou.tms.HomeWork14

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bunkou.tms.HomeWork14.entity.Country
import bunkou.tms.R
import com.squareup.picasso.Picasso


class CovidAdapter : RecyclerView.Adapter<CovidAdapter.CovidVH>() {
    private var summaryList = ArrayList<Country>()

    fun updateList(list: List<Country>) {
        summaryList = list as ArrayList<Country>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidVH {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.covid_item, parent, false)
        return CovidVH(view)
    }

    override fun onBindViewHolder(holder: CovidVH, position: Int) {
        holder.bind(summaryList[position])
    }

    override fun getItemCount() = summaryList.size


    class CovidVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val flagIv: ImageView
        private val countryNameTv: TextView
        private val totalConfirmedTv: TextView
        private val totalDeathsTv: TextView
        private val totalRecoveredTv: TextView

        init {
            with(itemView) {
                flagIv = findViewById(R.id.covid_item_flag_image)
                countryNameTv = findViewById(R.id.covid_item_country_name)
                totalConfirmedTv = findViewById(R.id.covid_item_total_confirmed)
                totalDeathsTv = findViewById(R.id.covid_item_total_deaths)
                totalRecoveredTv = findViewById(R.id.covid_item_total_recovered)
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind(country: Country) {
            with(country) {

                Picasso.get().load(flagUrl).into(flagIv)
                countryNameTv.text = "$countryName $countryCode"
                totalConfirmedTv.text = "Заражены: $totalConfirmed"
                totalDeathsTv.text = "Умерли: $totalDeaths"
                totalRecoveredTv.text = "Выздоровели: $totalRecovered"
            }
        }
    }
}