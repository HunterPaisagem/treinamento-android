package br.com.cwi.nespresso_app.presentation.feature.products.coffee.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ItemCoffeeBinding
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class CoffeeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvTitle = ItemCoffeeBinding.bind(view).tvCapsuleTitle
    private val tvSubtitle = ItemCoffeeBinding.bind(view).tvCapsuleSubtitle
    private val tvIntensity = ItemCoffeeBinding.bind(view).tvCapsuleIntensity
    private val tvPrice = ItemCoffeeBinding.bind(view).tvCapsulePrice
    private val ivImage = ItemCoffeeBinding.bind(view).ivCapsuleImage
    private val ivFavorite = ItemCoffeeBinding.bind(view).ivFavorite

    fun bind(context: Context, item: Coffee) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = context.getString(R.string.intensity, item.intensity)
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .error(R.drawable.coffees)
            .into(ivImage)

        //ivFavorite =
    }
}