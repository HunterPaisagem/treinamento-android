package br.com.cwi.nespresso_app.presentation.feature.products.accessorie.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.databinding.ItemAccessorieBinding
import br.com.cwi.nespresso_app.domain.entity.Accessory
import com.bumptech.glide.Glide

class AccessoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvTitle = ItemAccessorieBinding.bind(view).tvAccessorieTitle
    private val tvPrice = ItemAccessorieBinding.bind(view).tvCapsulePrice
    private val ivImage = ItemAccessorieBinding.bind(view).ivAccessorie
    private val ivFavorite = ItemAccessorieBinding.bind(view).ivAccessorieFav
    private val ivCart = ItemAccessorieBinding.bind(view).ivAccessorieCart

    fun bind(context: Context, item: Accessory){
        tvTitle.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)

    }
}