package com.example.suffle.ui.Feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.suffle.R
import kotlinx.android.synthetic.main.item_detail_review_reply.view.*

class ReplyAdapter (private val items: ArrayList<ReplyItem>) :
    RecyclerView.Adapter<ReplyAdapter.ViewHolder>()
    {

        override fun getItemCount() = items.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder?.bind(items[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val inflatedView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_detail_review_reply, parent, false)
            return ViewHolder(inflatedView)
        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            private var view: View = v
            fun bind(item: ReplyItem) {
                view.textView_subFeedDetail_replyUser.text = item.replyUserName
                view.textView_subFeedDetail_replyTaggedUser.text = item.replyTaggedUserName
                view.textView_subFeedDetail_replyContent.text = item.replyContent
            }
        }
    }