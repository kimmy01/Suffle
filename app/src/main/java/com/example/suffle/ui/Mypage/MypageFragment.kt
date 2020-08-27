@file:Suppress("UNREACHABLE_CODE")

package com.example.suffle.ui.Mypage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.suffle.R
import com.example.suffle.data.MyPageData
import com.example.suffle.ui.Feed.WritingReviewActivity1
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.android.synthetic.main.fragment_mypage_content.*

class MypageFragment : Fragment() {

    //val myPageData = arrayListOf<MyPageData>()
    lateinit var mypageAdpater: MypageGridAdapter

    val myPageData = arrayListOf<MyPageData>(
        MyPageData(R.drawable.image4),
        MyPageData(R.drawable.image5),
        MyPageData(R.drawable.image6),
        MyPageData(R.drawable.image7),
        MyPageData(R.drawable.image8),
        MyPageData(R.drawable.image9),
        MyPageData(R.drawable.image10),
        MyPageData(R.drawable.image4),
        MyPageData(R.drawable.image5),
        MyPageData(R.drawable.image6),
        MyPageData(R.drawable.image7),
        MyPageData(R.drawable.image8),
        MyPageData(R.drawable.image9),
        MyPageData(R.drawable.image10)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mypageAdpater =
            MypageGridAdapter(view.context,
                object :
                    MypageGridViewHolder.onClickListener {
                    override fun onClickItem(position: Int) {
                        Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                    }
                })

        recyclerView_mypage.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        recyclerView_mypage.adapter = mypageAdpater

        mypageAdpater.datas = myPageData
        mypageAdpater.notifyDataSetChanged()


        button_mypage_mylist.setOnClickListener {
            activity?.let{
                val intent = Intent(context, MyListActivity::class.java)
                startActivity(intent)
            }
        }

    }


}