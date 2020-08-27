package com.example.suffle.ui.Mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.MyListData
import kotlinx.android.synthetic.main.activity_my_list.*
import kotlinx.android.synthetic.main.activity_my_list_content.*

class MyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list)

        val myList = ArrayList<MyListData>()

        myList.add(MyListData(getDrawable(R.drawable.image1)!!, "라라브레드", "화랑대역"))
        myList.add(MyListData(getDrawable(R.drawable.image2)!!, "공릉동도깨비", "태릉입구역"))
        myList.add(MyListData(getDrawable(R.drawable.image3)!!, "프라이팬고기", "공릉역"))
        myList.add(MyListData(getDrawable(R.drawable.image1)!!, "브레드스팟", "화랑대역"))
        myList.add(MyListData(getDrawable(R.drawable.image2)!!, "포메인", "태릉입구역"))
        myList.add(MyListData(getDrawable(R.drawable.image3)!!, "샐러디", "공릉역"))

        beforeButton_myList.setOnClickListener {onBackPressed()}

        val myListAdapter = MyListAdapter(myList)
        recyclerView_myList.adapter = myListAdapter
        recyclerView_myList.layoutManager = LinearLayoutManager(this)

    }
}