package com.example.suffle.ui.Feed

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.ExampleList
import com.example.suffle.data.ExampleSubList
import com.example.suffle.ui.Feed.ExampleAdapter.*
import com.example.suffle.ui.Mypage.MyListActivity
import kotlinx.android.synthetic.main.item_example.view.*



class ExampleAdapter(private val context: Context, private val clickListener: ExampleViewHolder.onClickListener): RecyclerView.Adapter<ExampleViewHolder>() {
    val examplesub = arrayListOf<ExampleSubList>(
        ExampleSubList(R.drawable.image1),
        ExampleSubList(R.drawable.image2),
        ExampleSubList(R.drawable.image3),
        ExampleSubList(R.drawable.image1),
        ExampleSubList(R.drawable.image2))

    val example= arrayListOf<ExampleList>(
        ExampleList("강의정", "오늘의 파스타", "2.0", "파스타 생각보다 별로..", R.drawable.profileimage, examplesub),
        ExampleList("변다솔", "라라브레드", "4.0", "여기 빵이 정말 맛있더라 커피도 좋아", R.drawable.profileimage2, examplesub),
        ExampleList("김주은", "브레드스팟", "4.0", "인생빵집", R.drawable.thumbup, examplesub),
        ExampleList("김지현", "따미커피", "5.0", "더치커피 맛집!! 분위기도 예쁘다", R.drawable.button_profile, examplesub),
        ExampleList("김나영", "에슬로우커피", "4.0", "집이랑 조금만 더 가까우면 좋겠어 자주 가고 싶어", R.drawable.thumbup, examplesub)
    )

    //var exampleList = arrayListOf<ExampleList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_example, parent, false)
        //return ViewHolder(v, itemClick)
        return ExampleViewHolder(v, clickListener)
    }

    override fun getItemCount(): Int {
        return example.size
    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        //holder?.bind(exampleList[position])

        val exampleposition = example[position]

        holder?.bind(exampleposition)

        holder.textView_example_profileName.text = exampleposition.profilename
        holder.textView_example_placeName.text = exampleposition.placename
        holder.textView_example_starScore.text = exampleposition.ratingnum
        holder.textView_example_mainText.text = exampleposition.content

        holder.recyclerview_examplesub.layoutManager = LinearLayoutManager(holder.recyclerview_examplesub.context, LinearLayout.HORIZONTAL, false)
        val exampleSubAdapter = ExampleSubAdapter(example[position].recycler)
        holder.recyclerview_examplesub?.adapter = exampleSubAdapter

        exampleSubAdapter.examplesubList = examplesub

    }

    class ExampleViewHolder(itemView: View, private val clickListener: onClickListener): RecyclerView.ViewHolder(itemView) {

        //private var view: View = itemView

        fun bind(exampleList: ExampleList){
            Glide.with(itemView).load(exampleList.profileimage).into(itemView.imageView_example_profileImage)
            //itemView.setOnClickListener { itemClick(exampleList) }
        }
//        val textview_example = itemView.findViewById<TextView>(R.id.textView_example)

        init {
            itemView.setOnClickListener {
                clickListener.onClickItem(adapterPosition)
            }
        }

        interface onClickListener{
            fun onClickItem(position: Int)
        }

        val textView_example_profileName = itemView.findViewById<TextView>(R.id.textView_example_profileName)
        val textView_example_placeName = itemView.findViewById<TextView>(R.id.textView_example_placeName)
        val textView_example_starScore = itemView.findViewById<TextView>(R.id.textView_example_starScore)
        val textView_example_mainText = itemView.findViewById<TextView>(R.id.textView_example_mainText)
        val recyclerview_examplesub = itemView.findViewById<RecyclerView>(R.id.recyclerView_examplesub)
    }
}



























//class ExampleAdapter(context: Context
//                     //val itemClick: (ExampleList) -> Unit
//                    ): RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {
//    val examplesub = arrayListOf<ExampleSubList>(
//        ExampleSubList(R.drawable.image1),
//        ExampleSubList(R.drawable.image2),
//        ExampleSubList(R.drawable.image3),
//        ExampleSubList(R.drawable.image1),
//        ExampleSubList(R.drawable.image2))
//
//    val example= arrayListOf<ExampleList>(
//        ExampleList("강의정", "오늘의 파스타", "2.0", "파스타 생각보다 별로..", R.drawable.profileimage, examplesub),
//        ExampleList("변다솔", "라라브레드", "4.0", "여기 빵이 정말 맛있더라 커피도 좋아", R.drawable.profileimage2, examplesub),
//        ExampleList("김주은", "브레드스팟", "4.0", "인생빵집", R.drawable.thumbup, examplesub),
//        ExampleList("김지현", "따미커피", "5.0", "더치커피 맛집!! 분위기도 예쁘다", R.drawable.button_profile, examplesub),
//        ExampleList("김나영", "에슬로우커피", "4.0", "집이랑 조금만 더 가까우면 좋겠어 자주 가고 싶어", R.drawable.thumbup, examplesub)
//    )
//
//    //var exampleList = arrayListOf<ExampleList>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleAdapter.ViewHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_example, parent, false)
//        //return ViewHolder(v, itemClick)
//        return ViewHolder(v)
//    }
//
//    override fun getItemCount(): Int {
//        return example.size
//    }
//
//    @SuppressLint("WrongConstant")
//    override fun onBindViewHolder(holder: ExampleAdapter.ViewHolder, position: Int) {
//        //holder?.bind(exampleList[position])
//
//        val exampleposition = example[position]
//
//        holder?.bind(exampleposition)
//
//        holder.textView_example_profileName.text = exampleposition.profilename
//        holder.textView_example_placeName.text = exampleposition.placename
//        holder.textView_example_starScore.text = exampleposition.ratingnum
//        holder.textView_example_mainText.text = exampleposition.content
//
//        holder.recyclerview_examplesub.layoutManager = LinearLayoutManager(holder.recyclerview_examplesub.context, LinearLayout.HORIZONTAL, false)
//        val exampleSubAdapter = ExampleSubAdapter(example[position].recycler)
//        holder.recyclerview_examplesub?.adapter = exampleSubAdapter
//
//        exampleSubAdapter.examplesubList = examplesub
//
//        holder.itemView.setOnClickListener{}
//
//
//    }
//
//    class ViewHolder(itemView: View
//                     //val itemClick: (ExampleList) -> Unit
//                    ): RecyclerView.ViewHolder(itemView) {
//
//        private var view: View = itemView
//
//        fun bind(exampleList: ExampleList){
//            Glide.with(itemView.context).load(exampleList.profileimage).into(itemView.imageView_example_profileImage)
//            //itemView.setOnClickListener { itemClick(exampleList) }
//        }
////        val textview_example = itemView.findViewById<TextView>(R.id.textView_example)
//
//        val textView_example_profileName = itemView.findViewById<TextView>(R.id.textView_example_profileName)
//        val textView_example_placeName = itemView.findViewById<TextView>(R.id.textView_example_placeName)
//        val textView_example_starScore = itemView.findViewById<TextView>(R.id.textView_example_starScore)
//        val textView_example_mainText = itemView.findViewById<TextView>(R.id.textView_example_mainText)
//        val recyclerview_examplesub = itemView.findViewById<RecyclerView>(R.id.recyclerView_examplesub)
//    }
//}