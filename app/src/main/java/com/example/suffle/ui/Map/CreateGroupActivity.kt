package com.example.suffle.ui.Map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.suffle.R
import kotlinx.android.synthetic.main.activity_create_group.*

class CreateGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        //press back button
        act_create_group_btn_back.setOnClickListener {  finish()    }
    }
}