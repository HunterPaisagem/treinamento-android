package br.com.cwi.nespresso_app.presentation.feature.products.machine.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemMachineBinding
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

class MachineViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvName = ItemMachineBinding.bind(view).tvMachineName
    private val tvPrice = ItemMachineBinding.bind(view).tvMachinePrice
    private val ivImage = ItemMachineBinding.bind(view).ivMachineImage
    private val ivFavorite = ItemMachineBinding.bind(view).ivFavorite


    fun bind(context: Context, item: Machine) {
        tvName.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)
        //ivFavorite =
    }
}