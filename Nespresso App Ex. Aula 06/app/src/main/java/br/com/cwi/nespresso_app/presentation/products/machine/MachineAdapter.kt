package br.com.cwi.nespresso_app.presentation.products.machine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.base.toMoneyFormat
import br.com.cwi.nespresso_app.data.entity.MachineResponse
import br.com.cwi.nespresso_app.databinding.ItemMachineBinding
import com.bumptech.glide.Glide

class MachineAdapter(val context: Context, val list: List<MachineResponse>): Adapter<MachineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineViewHolder {
        return MachineViewHolder(inflateView(R.layout.item_machine, parent))
    }

    override fun onBindViewHolder(holder: MachineViewHolder, position: Int) {
        val item = list[position]

        holder.bind(context, item)
    }

    override fun getItemCount(): Int = list.size

    private fun inflateView(layout: Int, parent: ViewGroup): View = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}

class MachineViewHolder(view: View): ViewHolder(view) {
    private val tvName = ItemMachineBinding.bind(view).tvMachineName
    private val tvPrice = ItemMachineBinding.bind(view).tvMachinePrice
    private val ivImage = ItemMachineBinding.bind(view).ivMachineImage
    private val ivFavorite = ItemMachineBinding.bind(view).ivFavorite

    fun bind(context: Context, item: MachineResponse) {
        tvName.text = item.name
        tvPrice.text = item.price.toMoneyFormat()

        Glide.with(context)
            .load(item.image)
            .into(ivImage)
        //ivFavorite =
    }
}