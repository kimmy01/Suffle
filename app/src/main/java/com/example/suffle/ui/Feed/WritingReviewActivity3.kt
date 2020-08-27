package com.example.suffle.ui.Feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.suffle.R
import kotlinx.android.synthetic.main.activity_writing_review3.*

class WritingReviewActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_review3)

        val storeName = intent.getStringExtra("storeName")
        val content = intent.getStringExtra("content")

        if(content.isNullOrEmpty()){
            Toast.makeText(this, intent.getStringExtra("content"), Toast.LENGTH_LONG).show()
        }
        textView_writingReview3_4.text = content
        textView_writingReview3_3.text = storeName

        //토스트메시지로 확인
//        Toast.makeText(this, intent.getStringExtra("content"), Toast.LENGTH_LONG).show()

        imageView_writingReview3_before.setOnClickListener { onBackPressed() }

    }
}