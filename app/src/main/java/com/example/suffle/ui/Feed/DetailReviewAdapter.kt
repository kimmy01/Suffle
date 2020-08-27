package com.example.suffle.ui.Feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.DetailReviewData
import kotlinx.android.synthetic.main.item_detail_review_recycler.view.*

class DetailReviewAdapter (var detailreviewData: ArrayList<DetailReviewData>) :
    RecyclerView.Adapter<DetailReviewAdapter.ViewHolder>() {

    override fun getItemCount() = detailreviewData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bind(detailreviewData[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detail_review_recycler, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(detailreviewData: DetailReviewData){
            Glide.with(itemView.context).load(detailreviewData.image_food).into(itemView.imageView_detailReview)
        }
    }
}