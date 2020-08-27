package com.example.suffle.ui.Feed

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.DetailReviewData
import kotlinx.android.synthetic.main.activity_detail_review_content.*

class DetailReviewActivity : AppCompatActivity(), View.OnClickListener {

    val mainList = ArrayList<DetailReviewData>()
    val mainAdapter = DetailReviewAdapter(mainList)


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_review)

        textView_subFeedDetail_commentDetail.setOnClickListener(this)

        beforeButton_feedDetail.setOnClickListener { onBackPressed() }

        val reply= arrayListOf<ReplyItem>(
            ReplyItem("강의정", "김주은", "이거 철길에 있는거임?"),
            ReplyItem("김나영", "강의정", "다음에 같이 가자~"),
            ReplyItem("김지현", "김주은", "너무 맛있어 보인다!"),
            ReplyItem("변다솔", "김주은", "나도 줘"),
            ReplyItem("강의정", "김주은", "이거 철길에 있는거임?"),
            ReplyItem("김나영", "강의정", "다음에 같이 가자~"),
            ReplyItem("김지현", "김주은", "너무 맛있어 보인다!"),
            ReplyItem("변다솔", "김주은", "나도 줘"),
            ReplyItem("강의정", "김주은", "이거 철길에 있는거임?"),
            ReplyItem("김나영", "강의정", "다음에 같이 가자~"),
            ReplyItem("김지현", "김주은", "너무 맛있어 보인다!"),
            ReplyItem("변다솔", "김주은", "나도 줘")
        )

        val replyAdapter = ReplyAdapter(reply)
        recyclerView_subFeedDetail_reply.adapter = replyAdapter

        recyclerView_subFeedDetail_1.adapter = mainAdapter
        recyclerView_subFeedDetail_1.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)

        loadMainDatas()

    }

    override fun onClick(v: View) {
        when(v?.id) {
            textView_subFeedDetail_commentDetail.id -> {
                val dlg = CommentDialog(this)
                dlg.setOnOKClickedListener { content ->

                }
                dlg.start("메인 내용 변경")
            }
        }
    }


    private fun loadMainDatas(){
        mainList.apply {
            add(DetailReviewData(getDrawable(R.drawable.image1)!!))
            add(DetailReviewData(getDrawable(R.drawable.image2)!!))
            add(DetailReviewData(getDrawable(R.drawable.image3)!!))
        }

        mainAdapter.detailreviewData = mainList
        mainAdapter.notifyDataSetChanged()
    }
}