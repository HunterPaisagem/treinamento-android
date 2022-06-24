package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.entity.ItemType
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.viewHolder.CoffeeViewHolder
import br.com.cwi.nespresso_app.presentation.feature.products.viewHolder.CategoryViewHolder

class CapsulesAdapter(
    val context: Context,
    val list: List<Type>,
    private val onCoffeeClick: (id: Int) -> Unit,
    private val onFavoriteClick: (Coffee) -> Unit
): Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == ItemType.CATEGORY.value){
            CategoryViewHolder(inflateView(R.layout.item_category, parent))
        } else {
            CoffeeViewHolder(inflateView(R.layout.item_coffee, parent), onFavoriteClick)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        if(item.type == ItemType.CATEGORY) {
            (holder as CategoryViewHolder).tvCategory.text = (item as Category).category
        } else {
            (holder as CoffeeViewHolder).bind(context, item as Coffee)
            holder.itemView.setOnClickListener {
                onCoffeeClick(item.id)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int) = list[position].type.value

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}