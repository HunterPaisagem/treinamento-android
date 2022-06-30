package br.com.cwi.nespresso_app.presentation.feature.favorites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.feature.favorites.viewHolder.FavoritesViewHolder

class FavoritesAdapter(val context: Context, val list: List<Coffee>): RecyclerView.Adapter<FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(inflateView(R.layout.item_favorites, parent))
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val item = list[position]

        holder.bind(context, item)
    }

    override fun getItemCount(): Int = list.size

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}