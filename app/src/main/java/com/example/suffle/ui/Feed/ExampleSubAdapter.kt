package com.example.suffle.ui.Feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.ExampleSubList
import kotlinx.android.synthetic.main.item_example_sub.view.*

class ExampleSubAdapter(examplesubList: ArrayList<ExampleSubList>) :
    RecyclerView.Adapter<ExampleSubAdapter.ViewHolder>() {

    var examplesubList = arrayListOf<ExampleSubList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleSubAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_example_sub, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return examplesubList.size
    }

    override fun onBindViewHolder(holder: ExampleSubAdapter.ViewHolder, position: Int) {
        val example = examplesubList[position]
//        holder?.bind(mainData[position])
//        holder?.exampleimage.drawable = example.get("image")
//        holder.textview_examplesub.text = example.exampletext
        holder?.bind(example)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        val exampleimage = itemView.findViewById<ImageView>(R.id.imageView_example)
        fun bind(examplesubList: ExampleSubList) {
            Glide.with(itemView.context).load(examplesubList.exampleimage).into(itemView.imageView_example)
        }
//        val textview_examplesub = itemView.findViewById<TextView>(R.id.textView_examplesub)
    }
}