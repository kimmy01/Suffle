package com.example.suffle.ui.Mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.MyListData
import kotlinx.android.synthetic.main.item_mylist_recycler.view.*

class MyListAdapter( private var mylistitems: ArrayList<MyListData>) :
    RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    override fun getItemCount() = mylistitems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bind(mylistitems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mylist_recycler, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(myListitem: MyListData){
            Glide.with(itemView.context).load(myListitem.myListImage).into(itemView.imageView_myListItem)
//            view.imageView_noticeitem_1.setImageResource(myListitem.noticeImage)
            view.textView_myListItem_placeName.text = myListitem.myListPlaceName
            view.textView_myListItem_subwayName.text = myListitem.myListSubwayName
            view.button_myListItem_1.text = "인스타에서 핫한"
            view.button_myListItem_2.text = "카페"
            view.button_myListItem_3.text = "한식"
        }
    }


}