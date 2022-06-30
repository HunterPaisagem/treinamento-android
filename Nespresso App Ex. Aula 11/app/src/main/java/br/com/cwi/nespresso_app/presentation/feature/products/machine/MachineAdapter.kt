package br.com.cwi.nespresso_app.presentation.feature.products.machine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.presentation.feature.products.machine.viewHolder.MachineViewHolder

class MachineAdapter(val context: Context, val list: List<Machine>): Adapter<MachineViewHolder>() {

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