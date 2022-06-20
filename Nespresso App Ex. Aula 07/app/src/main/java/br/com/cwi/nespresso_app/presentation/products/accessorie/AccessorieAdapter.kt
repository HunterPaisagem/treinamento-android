package br.com.cwi.nespresso_app.presentation.products.accessorie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Accessory
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.ItemType
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.products.accessorie.viewHolder.AccessoryViewHolder
import br.com.cwi.nespresso_app.presentation.products.viewHolder.CategoryViewHolder

class AccessorieAdapter(val context: Context, val list: List<Type>): Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == ItemType.CATEGORY.value){
            CategoryViewHolder(inflateView(R.layout.item_category, parent))
        } else {
            AccessoryViewHolder(inflateView(R.layout.item_accessorie, parent))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        if(item.type == ItemType.CATEGORY){
            (holder as CategoryViewHolder).tvCategory.text = (item as Category).category
        } else {
            (holder as AccessoryViewHolder).bind(context, item as Accessory)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int) = list[position].type.value

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}
