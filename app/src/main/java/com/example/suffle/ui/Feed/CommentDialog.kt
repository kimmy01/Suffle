package com.example.suffle.ui.Feed

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.suffle.R

class CommentDialog(context:Context) {
    private val dlg = Dialog(context)
    private lateinit var lblDesc : TextView
    private lateinit var cancel : TextView
    private lateinit var ok : Button
    private lateinit var listener : CommentDialogOKClickedListener

    fun start(content: String) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(R.layout.comment_dialog)
        dlg.setCancelable(false)

        lblDesc = dlg.findViewById(R.id.content)
        lblDesc.text = content
//        ok = dlg.findViewById(R.id.ok)
//        ok.setOnClickListener {
//            listener.onOKClicked("확인 누름")
//            dlg.dismiss()
//        }
        cancel = dlg.findViewById(R.id.cancel)
        cancel.setOnClickListener {
            dlg.dismiss()
        }
        dlg.show()
    }

    fun setOnOKClickedListener(listener: (String) -> Unit) {
        this.listener = object : CommentDialogOKClickedListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }

    interface CommentDialogOKClickedListener {
        fun onOKClicked(content: String)
    }
}