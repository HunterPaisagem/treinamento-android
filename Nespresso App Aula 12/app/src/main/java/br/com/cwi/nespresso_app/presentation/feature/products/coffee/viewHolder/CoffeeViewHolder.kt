package br.com.cwi.nespresso_app.presentation.feature.products.coffee.viewHolder

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ItemCoffeeBinding
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class CoffeeViewHolder(
    itemView: View,
    private val onFavoriteClick: (Coffee) -> Unit
): RecyclerView.ViewHolder(itemView) {
    private val tvTitle = ItemCoffeeBinding.bind(itemView).tvCapsuleTitle
    private val tvSubtitle = ItemCoffeeBinding.bind(itemView).tvCapsuleSubtitle
    private val tvIntensity = ItemCoffeeBinding.bind(itemView).tvCapsuleIntensity
    private val tvPrice = ItemCoffeeBinding.bind(itemView).tvCapsulePrice
    private val ivImage = ItemCoffeeBinding.bind(itemView).ivCapsuleImage
    private val ivFavorite = ItemCoffeeBinding.bind(itemView).ivFavorite

    fun bind(context: Context, item: Coffee) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = context.getString(R.string.intensity, item.intensity)
        tvPrice.text = item.unitPrice.toMoneyFormat()

        with(ivFavorite){
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isFavorite = !item.isFavorite
                setImageDrawable(getFavoriteIcon(item))
                onFavoriteClick(item)
            }

        }

        Glide.with(context)
            .load(item.urlImage)
            .error(R.drawable.coffees)
            .into(ivImage)
    }

    private fun getFavoriteIcon(coffee: Coffee): Drawable? {
        return ContextCompat.getDrawable(itemView.context,
            if(coffee.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_outline
        )
    }
}