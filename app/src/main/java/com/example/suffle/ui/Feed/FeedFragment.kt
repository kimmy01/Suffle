package com.example.suffle.ui.Feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.ExampleList
import com.example.suffle.data.ExampleSubList
import kotlinx.android.synthetic.main.fragment_feed.*

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
//        val examplesub = arrayListOf<ExampleSubList>(
//            ExampleSubList(R.drawable.image1),
//            ExampleSubList(R.drawable.image2),
//            ExampleSubList(R.drawable.image3),
//            ExampleSubList(R.drawable.image4),
//            ExampleSubList(R.drawable.image5)
//        )

//        val example= arrayListOf<ExampleList>(
//            ExampleList("강의정", "오늘의 파스타", "2.0", "파스타 생각보다 별로..", R.drawable.profileimage, examplesub),
//            ExampleList("변다솔", "라라브레드", "4.0", "여기 빵이 정말 맛있더라 커피도 좋아", R.drawable.profileimage2, examplesub),
//            ExampleList("김주은", "브레드스팟", "4.0", "인생빵집", R.drawable.thumbup, examplesub),
//            ExampleList("김지현", "따미커피", "5.0", "더치커피 맛집!! 분위기도 예쁘다", R.drawable.button_profile, examplesub),
//            ExampleList("김나영", "에슬로우커피", "4.0", "집이랑 조금만 더 가까우면 좋겠어 자주 가고 싶어", R.drawable.thumbup, examplesub)
//        )


        //val exampleAdapter = ExampleAdapter(example)
        exampleAdapter = ExampleAdapter(view.context)
        recyclerview_example.adapter = exampleAdapter
        recyclerview_example.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //exampleAdapter.exampleList = example
    }


}