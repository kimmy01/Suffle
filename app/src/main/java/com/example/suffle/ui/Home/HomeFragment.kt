package com.example.suffle.ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.MainRecommandData
import com.example.suffle.data.PlaceData
import kotlinx.android.synthetic.main.fragment_home_content.*


class HomeFragment : Fragment() {

    val placeDatas = mutableListOf<PlaceData>()
    val recommandDatas = mutableListOf<MainRecommandData>()
    var tmp = 0
    lateinit var placeLinearAdapter: PlaceLinearAdapter
    lateinit var placeGridAdapter: PlaceGridAdapter
    lateinit var recommandAdapter: RecommandAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        home_sliding_layout.isNestedScrollingEnabled = true
//
//        home_sliding_layout.setFadeOnClickListener(View.OnClickListener {
//            home_sliding_layout.panelState = SlidingUpPanelLayout.PanelState.HIDDEN
//        })

        placeDatas.clear()

        //Adapter Initialization
        recommandAdapter = RecommandAdapter(view.context)

        placeLinearAdapter = PlaceLinearAdapter(view.context,
            object : PlaceLinearViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        placeGridAdapter = PlaceGridAdapter(view.context,
            object : PlaceGridViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        frag_home_rv_recommand.adapter = recommandAdapter
        frag_home_rv_recommand.layoutManager = context?.let { CenterZoomLinearLayoutManager(it, 10f, 5f) }

//        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
//        layoutManager.stackFromEnd = true
//        frag_home_rv_recommand.layoutManager = layoutManager

//        val snapHelper = LinearSnapHelper() // snaps the center
//        snapHelper.attachToRecyclerView(frag_home_rv_recommand)

        frag_home_rv_place.adapter = placeLinearAdapter
        frag_home_rv_place.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        frag_home_btn_layout.setOnClickListener {
            if(tmp == 0){
                tmp = 1
                placeDatas.clear()
                frag_home_btn_layout.setImageResource(R.drawable.icon_linear_layout)
                frag_home_rv_place.adapter = placeLinearAdapter
                frag_home_rv_place.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                loadPlaceDatas()
            }else{
                tmp = 0
                placeDatas.clear()
                frag_home_btn_layout.setImageResource(R.drawable.icon_grid_layout)
                frag_home_rv_place.layoutManager =
                    GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                frag_home_rv_place.adapter = placeGridAdapter
                loadPlaceDatas()
            }

        }


        frag_home_btn_filter_all.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.VISIBLE
            frag_home_btn_filter_food_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.INVISIBLE
        }

        frag_home_btn_filter_food.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_food_bar.visibility = View.VISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.INVISIBLE

//            home_sliding_layout.setDragView(R.layout.bottom_sheet_food)
//            home_sliding_layout.panelHeight = 467

        }

        frag_home_btn_filter_cafe.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_food_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.VISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.INVISIBLE


//            home_sliding_layout.setDragView(R.layout.bottom_sheet_cafe)
//            home_sliding_layout.panelHeight = 467
        }

        frag_home_btn_filter_drink.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_food_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.VISIBLE

//            home_sliding_layout.panelHeight = 467
        }

        loadPlaceDatas()
        loadRecoDatas()

    }

    private fun loadPlaceDatas(){
        placeDatas.apply {
            add(
                PlaceData(
                    img_place = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSnLXIlflHc2Ck5_YNNYKn5zz4MCG2u5bKvZQ&usqp=CAU",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://lh3.googleusercontent.com/proxy/0fSPDWXT8LvpXQsFwlCGm4Amkd3gw-Z-p3v1q-RsrUW1Z1kj7JOpuzOCzbn7Uu_cmqnPTJE1hAXzO2st9vCczfUKqXJiKnhCe1QNHMXT1N0y6C3Nic6_gAazhK2ipj9JsT5DkcSAfYWUIKuKP8riygED8Fzy-N3rHjnTX7Z8ltQJX87A9GPfL6PVW2Ez4_3dZTEZOuq6GRk1Sc50VAtQYqR6h2HpwQv9wJegSKuvmjGYC0Q1tJBQwXo4TjvBqKYkdfOBpx8ZkRZn-5El1i9trdHEF1ne",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
        }

        if(frag_home_rv_place.adapter == placeLinearAdapter){
            placeLinearAdapter.datas = placeDatas
            placeLinearAdapter.notifyDataSetChanged()
        }else{
            placeGridAdapter.datas = placeDatas
            placeGridAdapter.notifyDataSetChanged()
        }
    }

    private fun loadRecoDatas(){
        recommandDatas.apply {
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
        }

        recommandAdapter.datas = recommandDatas
        recommandAdapter.notifyDataSetChanged()
    }

}