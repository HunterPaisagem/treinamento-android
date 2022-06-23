package br.com.cwi.nespresso_app.presentation.feature.products.coffee.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.details.viewHolder.CoffeeDetailsViewHolder

class CoffeeDetailsAdapter(
    val context: Context,
    val list: List<String>
): Adapter<CoffeeDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeDetailsViewHolder {
        return CoffeeDetailsViewHolder(inflateView(R.layout.item_coffee_degustation, parent))
    }

    override fun onBindViewHolder(holder: CoffeeDetailsViewHolder, position: Int) {
        val item = list[position]

        holder.bind(context, item)
    }

    override fun getItemCount(): Int = list.size

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}