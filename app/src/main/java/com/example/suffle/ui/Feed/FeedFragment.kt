@file:Suppress("UNREACHABLE_CODE")

package com.example.suffle.ui.Feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.ExampleList
import com.example.suffle.data.ExampleSubList
import com.example.suffle.ui.Home.PlaceGridAdapter
import com.example.suffle.ui.Home.PlaceGridViewHolder
import com.example.suffle.ui.Map.MapPlaceAdapter
import com.example.suffle.ui.Map.MapPlaceViewHolder
import com.example.suffle.ui.Mypage.MyListActivity
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.android.synthetic.main.fragment_feed_content.*
import kotlinx.android.synthetic.main.fragment_mypage_content.*

class FeedFragment : Fragment() {

    lateinit var exampleAdapter: ExampleAdapter
    val datas = mutableListOf<ExampleList>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //val exampleAdapter = ExampleAdapter(example)



        //exampleAdapter = ExampleAdapter(view.context)



        exampleAdapter = ExampleAdapter(view.context,
            object : ExampleAdapter.ExampleViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    activity?.let{
                        val intent = Intent(context, DetailReviewActivity::class.java)
                        startActivity(intent)
                    }
                }
            })


        recyclerview_example.adapter = exampleAdapter
        recyclerview_example.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //exampleAdapter.exampleList = example

        floatingButton_feed.setOnClickListener {
            activity?.let{
                val intent = Intent(context, WritingReviewActivity1::class.java)
                startActivity(intent)
            }
        }

    }


}