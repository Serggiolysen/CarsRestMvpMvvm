package com.lysenko.cars_MVP.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lysenko.cars_MVP.R
import com.lysenko.cars_MVP.model.entity.Poi

class RVAdapter(private var items: List<Poi>, private val listener: Clicklistener) :
    RecyclerView.Adapter<RViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val myItemView = LayoutInflater
            .from(parent.context).inflate(R.layout.rv_item, parent, false)
        val holder = RViewHolder(myItemView)
        holder.itemView.setOnClickListener {
            listener.onItemClick(items[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        holder.bind(items[position])
    }

    interface Clicklistener {
        fun onItemClick(item: Poi)
    }

}

class RViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textFleetType = view.findViewById<TextView>(R.id.text_view)

    fun bind(item: Poi) {
        textFleetType.text = item.fleeType.toString()
    }
}