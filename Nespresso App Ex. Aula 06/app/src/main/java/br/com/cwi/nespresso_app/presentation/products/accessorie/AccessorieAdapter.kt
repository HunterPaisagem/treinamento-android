package br.com.cwi.nespresso_app.presentation.products.accessorie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.base.toMoneyFormat
import br.com.cwi.nespresso_app.data.entity.AccessoryCategoryResponse
import br.com.cwi.nespresso_app.data.entity.AccessoryItensResponse
import br.com.cwi.nespresso_app.data.entity.AccessoryType
import br.com.cwi.nespresso_app.databinding.ItemAccessorieBinding
import br.com.cwi.nespresso_app.presentation.products.category.CategoryViewHolder
import com.bumptech.glide.Glide

private const val VIEW_TYPE_CATEGORY = 0

class AccessorieAdapter(val context: Context, val list: List<AccessoryType>): Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == VIEW_TYPE_CATEGORY){
            CategoryViewHolder(inflateView(R.layout.item_category, parent))
        } else {
            AccessoryViewHolder(inflateView(R.layout.item_accessorie, parent))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        if(item.type == VIEW_TYPE_CATEGORY){
            (holder as CategoryViewHolder).tvCategory.text = (item as AccessoryCategoryResponse).category
        } else {
            (holder as AccessoryViewHolder).bind(context, item as AccessoryItensResponse)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int) = list[position].type

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}

private class AccessoryViewHolder(view: View): ViewHolder(view) {
    private val tvTitle = ItemAccessorieBinding.bind(view).tvAccessorieTitle
    private val tvPrice = ItemAccessorieBinding.bind(view).tvCapsulePrice
    private val ivImage = ItemAccessorieBinding.bind(view).ivAccessorie
    private val ivFavorite = ItemAccessorieBinding.bind(view).ivAccessorieFav
    private val ivCart = ItemAccessorieBinding.bind(view).ivAccessorieCart

    fun bind(context: Context, item: AccessoryItensResponse){
        tvTitle.text = item.name
        tvPrice.text = item.price.toMoneyFormat()

        Glide.with(context)
            .load(item.image)
            .into(ivImage)
    }
}
