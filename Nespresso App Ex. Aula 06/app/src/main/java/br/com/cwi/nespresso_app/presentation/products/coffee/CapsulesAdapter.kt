package br.com.cwi.nespresso_app.presentation.products.coffee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.base.toMoneyFormat
import br.com.cwi.nespresso_app.data.entity.CapsuleType
import br.com.cwi.nespresso_app.data.entity.CategoryResponse
import br.com.cwi.nespresso_app.data.entity.CoffeeResponse
import br.com.cwi.nespresso_app.databinding.ItemCoffeeBinding
import br.com.cwi.nespresso_app.presentation.products.category.CategoryViewHolder
import com.bumptech.glide.Glide

private const val VIEW_TYPE_CATEGORY = 1

class CapsulesAdapter(val context: Context, val list: List<CapsuleType>): Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == VIEW_TYPE_CATEGORY){
            CategoryViewHolder(inflateView(R.layout.item_category, parent))
        } else {
            CoffeeViewHolder(inflateView(R.layout.item_coffee, parent))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        if(item.type == VIEW_TYPE_CATEGORY) {
            (holder as CategoryViewHolder).tvCategory.text = (item as CategoryResponse).category
        } else {
            (holder as CoffeeViewHolder).bind(context, item as CoffeeResponse)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int) = list[position].type

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}

class CoffeeViewHolder(view: View): ViewHolder(view) {
    private val tvTitle = ItemCoffeeBinding.bind(view).tvCapsuleTitle
    private val tvSubtitle = ItemCoffeeBinding.bind(view).tvCapsuleSubtitle
    private val tvIntensity = ItemCoffeeBinding.bind(view).tvCapsuleIntensity
    private val tvPrice = ItemCoffeeBinding.bind(view).tvCapsulePrice
    private val ivImage = ItemCoffeeBinding.bind(view).ivCapsuleImage
    private val ivFavorite = ItemCoffeeBinding.bind(view).ivFavorite

    fun bind(context: Context, item: CoffeeResponse) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = "Intensidade: ${item.intensity.toString()}"
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .error(R.drawable.coffees)
            .into(ivImage)

        //ivFavorite =
    }
}