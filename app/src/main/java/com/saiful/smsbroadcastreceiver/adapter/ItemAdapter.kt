package com.saiful.smsbroadcastreceiver.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saiful.smsbroadcastreceiver.R

class ItemAdapter(private val itemList: List<*>): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        val number: TextView = view.findViewById(R.id.number)
        val count: TextView = view.findViewById(R.id.count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ItemHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = itemList[position]
        val temp = item.toString().split(")","(",",")

        holder.number.text = temp[1]
        holder.count.text = temp[2]
    }
}