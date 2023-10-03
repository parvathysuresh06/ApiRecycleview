package com.example.apirecycleview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
class AdapterClass(private val items: List<Product?>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val context = holder.itemView.context
        val product = items[position]
        holder.title.text = product?.title
        val price = product?.price
        val formattedPrice = price?.let { "₹${it}" } ?: "Price not available"
        val description = product?.description
        val rating = product?.rating.toString()
        val imageUrl = product?.images?.get(0)

        holder.price.text = formattedPrice
        holder.desc.text = description
        holder.rating.text = rating

        Picasso.get().load(imageUrl).into(holder.image)

        holder.buy.setOnClickListener {
            // Create an Intent to start the DetailsActivity
            val intent = Intent(context, DetailActivity::class.java)

            // Put the data as extras in the Intent
            intent.putExtra("title", product?.title)
            intent.putExtra("price", formattedPrice)
            intent.putExtra("description", description)
            intent.putExtra("rating", rating)
            intent.putExtra("image", imageUrl)

            // Start the DetailsActivity
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}


class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.title)
    val price = itemView.findViewById<TextView>(R.id.price)
    val desc=itemView.findViewById<TextView>(R.id.de)
    val rating=itemView.findViewById<TextView>(R.id.rating)
    val image=itemView.findViewById<ImageView>(R.id.image)
    val buy=itemView.findViewById<Button>(R.id.buy)
}
