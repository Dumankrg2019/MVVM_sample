package kz.dev.countries_catalin_stefan.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.dev.countries_catalin_stefan.R
import kz.dev.countries_catalin_stefan.model.Country
import kz.dev.countries_catalin_stefan.util.getProgressDrawable
import kz.dev.countries_catalin_stefan.util.loadimage

class CountryListAdapter(var countries: ArrayList<Country>):
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view) {

        private val ImageView = view.findViewById<ImageView>(R.id.ImageView)
        val countryName = view.findViewById<TextView>(R.id.name)
        private val capital = view.findViewById<TextView>(R.id.capital)
        private val progressDrawable = getProgressDrawable(view.context)  // вызывает функц из Ютил
        fun bind(country: Country) {
            countryName.text = country.nameCountry
            capital.text = country.capital
//            Glide.with(itemView)
//                .load(country.flag)   есть альтернативный  вариант
//                .into(ImageView)
            ImageView.loadimage(country.flag, progressDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)

    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size
}