package com.example.suffle.ui.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.PlaceData

class PlaceLinearAdapter (private val context: Context, private val clickListener: PlaceLinearViewHolder.onClickListener): RecyclerView.Adapter<PlaceLinearViewHolder>(){

    var datas = mutableListOf<PlaceData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceLinearViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_home_linear_list, parent, false)
        return PlaceLinearViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: PlaceLinearViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class PlaceLinearViewHolder(itemview: View, val clickListener: onClickListener) : RecyclerView.ViewHolder(itemview){
    val img_place = itemview.findViewById<ImageView>(R.id.img_place)
    val txt_placeName = itemView.findViewById<TextView>(R.id.txt_placeName)
    val txt_distance = itemView.findViewById<TextView>(R.id.txt_distance)
    val txt_thumbUp = itemView.findViewById<TextView>(R.id.txt_thumbUp)
    val txt_thumbDown = itemView.findViewById<TextView>(R.id.txt_thumbDown)

    fun bind(placeData: PlaceData) {
        Glide.with(itemView).load(placeData.img_place).into(img_place);
        txt_placeName.text = placeData.txt_place
        txt_distance.text = placeData.txt_distance
        txt_thumbUp.text = placeData.txt_thumbUp
        txt_thumbDown.text = placeData.txt_thumbDown
    }

    init {
        itemView.setOnClickListener {
            clickListener.onClickItem(adapterPosition)
        }
    }

    interface onClickListener {
        fun onClickItem(position: Int)
    }
}