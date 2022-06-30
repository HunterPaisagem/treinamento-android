package br.com.cwi.nespresso_app.presentation.feature.products.coffee.details.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemCoffeeDegustationBinding

class CoffeeDetailsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvName = ItemCoffeeDegustationBinding.bind(view).tvDegustationName

    fun bind(item: String) {
        tvName.text = item
    }
}