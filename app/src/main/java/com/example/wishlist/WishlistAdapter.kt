package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val items: MutableList<WishlistItem>) :
    RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {


    class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        val priceTextView: TextView = itemView.findViewById(R.id.tv_item_price)
        val urlTextView: TextView = itemView.findViewById(R.id.tv_item_url)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wishlist, parent, false)
        return WishlistViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = "Price: ${item.price}"
        holder.urlTextView.text = item.url
    }

    override fun getItemCount(): Int = items.size

    fun addItem(item: WishlistItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }
}