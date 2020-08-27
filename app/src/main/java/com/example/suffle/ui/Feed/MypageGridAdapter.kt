package com.example.suffle.ui.Feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.MyPageData

class MypageGridAdapter (private val context: Context,
                         private val clickListener: MypageGridViewHolder.onClickListener): RecyclerView.Adapter<MypageGridViewHolder>(){

    var datas = arrayListOf<MyPageData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageGridViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_grid_mypage, parent, false)
        return MypageGridViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MypageGridViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class MypageGridViewHolder(itemview: View, val clickListener: onClickListener) : RecyclerView.ViewHolder(itemview){

    val mypageImage = itemview.findViewById<ImageView>(R.id.imageView_mypage_item)


    fun bind(mypageData: MyPageData) {
        Glide.with(itemView).load(mypageData.mypageImage).into(mypageImage)

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