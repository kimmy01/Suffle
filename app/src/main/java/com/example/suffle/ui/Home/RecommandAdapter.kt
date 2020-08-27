package com.example.suffle.ui.Home

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.MainRecommandData

class RecommandAdapter(private val context: Context) : RecyclerView.Adapter<RecommandViewHolder>() {

    var datas = mutableListOf<MainRecommandData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommandViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_frag_home_recommand, parent, false)
        return RecommandViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecommandViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }
}

class RecommandViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

//    val txt_recommand = itemView.findViewById<TextView>(R.id.frag_home_txt_recommand)
    val img_food = itemView.findViewById<ImageView>(R.id.frag_home_img_recommand_food)
//    val img_person = itemview.findViewById<ImageView>(R.id.frag_home_img_recommand_person)

    @SuppressLint("SetTextI18n")
    fun bind(mainRecommandData: MainRecommandData) {
//        txt_recommand.text = mainRecommandData.txt_personName} + "추천 - " + mainRecommandData.txt_storeName
//        txt_recommand.text = mainRecommandData.txt_personName
//        Glide.with(itemView).load(mainRecommandData.img_person).into(img_person)
        Glide.with(itemView).load(mainRecommandData.img_food).into(img_food)

    }
}