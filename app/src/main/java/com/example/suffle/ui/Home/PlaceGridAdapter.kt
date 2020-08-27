package com.example.suffle.ui.Home

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.PlaceData

class PlaceGridAdapter (private val context: Context, private val clickListener: PlaceGridViewHolder.onClickListener): RecyclerView.Adapter<PlaceGridViewHolder>(){

    var datas = mutableListOf<PlaceData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceGridViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_home_grid_list, parent, false)
        return PlaceGridViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: PlaceGridViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class PlaceGridViewHolder(itemview: View, val clickListener: onClickListener) : RecyclerView.ViewHolder(itemview){
//    val txt_placeName = itemView.findViewById<TextView>(R.id.txt_placeName)
//    val txt_distance = itemView.findViewById<TextView>(R.id.txt_distance)
//    val txt_thumbUp = itemView.findViewById<TextView>(R.id.txt_thumbUp)
//    val txt_thumbDown = itemView.findViewById<TextView>(R.id.txt_thumbDown)
    val img_place = itemview.findViewById<ImageView>(R.id.img_place)


    fun bind(placeData: PlaceData) {
//        txt_placeName.text = placeData.txt_place
//        txt_distance.text = placeData.txt_distance
//        txt_thumbUp.text = placeData.txt_thumbUp
//        txt_thumbDown.text = placeData.txt_thumbDown
        Glide.with(itemView).load(placeData.img_place).into(img_place)

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