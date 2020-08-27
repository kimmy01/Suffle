package com.example.suffle.ui.Map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.PersonListData
import kotlinx.android.synthetic.main.activity_create_friend.*

class CreateFriendActivity : AppCompatActivity() {

    lateinit var friendAdapter: FriendAdapter
    val friendDatas = mutableListOf<PersonListData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_friend)

        //press back button
        act_create_friend_btn_back.setOnClickListener {  finish()    }

        //Adapter Initialization
        friendAdapter = FriendAdapter(this,
            object : FriendViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(
                        this@CreateFriendActivity,
                        friendDatas[position].txt_personName,
                        Toast.LENGTH_SHORT
                    ).show()

                }

            })

        act_create_friend_rv.adapter = friendAdapter
        act_create_friend_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        loadDatas()

    }

    private fun loadDatas() {
        friendDatas.apply {
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍1"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍2"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍3"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍4"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍4"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍4"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "멍4"
                )
            )
        }

        friendAdapter.datas = friendDatas
        friendAdapter.notifyDataSetChanged()
    }

}