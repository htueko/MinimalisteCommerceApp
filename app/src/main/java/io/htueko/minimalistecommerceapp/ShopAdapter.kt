package io.htueko.minimalistecommerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class ShopAdapter(var itemList: ArrayList<ShopItem>) : RecyclerView.Adapter<ShopAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemLists = itemList[position]
        holder.title.text = itemLists.title
        holder.price.text = itemLists.price.toString()
        Picasso.get().load(itemLists.image).resize(50, 50).centerCrop().into(holder.photo)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo = itemView.findViewById<ImageView>(R.id.img_view_card)!!
        val title = itemView.findViewById<TextView>(R.id.txt_title_card)!!
        val price = itemView.findViewById<TextView>(R.id.txt_price_card)!!
    }
}