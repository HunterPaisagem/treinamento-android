package br.com.cwi.nespresso_app.presentation.products.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemCategoryBinding

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvCategory = ItemCategoryBinding.bind(view).tvCategory
}