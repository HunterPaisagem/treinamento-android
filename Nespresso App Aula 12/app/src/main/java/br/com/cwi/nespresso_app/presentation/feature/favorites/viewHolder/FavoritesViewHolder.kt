package br.com.cwi.nespresso_app.presentation.feature.favorites.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemFavoritesBinding
import br.com.cwi.nespresso_app.domain.entity.Product
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class FavoritesViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val tvProductName = ItemFavoritesBinding.bind(view).tvProductName
    private val tvProductPrice = ItemFavoritesBinding.bind(view).tvProductPrice
    private val ivProductImage = ItemFavoritesBinding.bind(view).ivProductImage
    private val tvProductType = ItemFavoritesBinding.bind(view).tvProductType

    fun bind(context: Context, item: Product) {
        tvProductName.text = item.name
        tvProductType.text = item.productType.value
        tvProductPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivProductImage)
    }
}