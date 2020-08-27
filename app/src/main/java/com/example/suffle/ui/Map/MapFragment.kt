package com.example.suffle.ui.Map

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.MarkerData
import com.example.suffle.data.PersonListData
import com.example.suffle.data.PlaceData
import kotlinx.android.synthetic.main.bottom_sheet_map.*
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.android.synthetic.main.fragment_map_content.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView


class MapFragment : Fragment() {

    val placeDatas = mutableListOf<PlaceData>()
    val personDatas = mutableListOf<PersonListData>()

    val markerData = ArrayList<MarkerData>()
    val personMarkerData = ArrayList<MarkerData>()

    lateinit var mapPlaceAdapter: MapPlaceAdapter
    lateinit var mapPersonAdapter: MapPersonAdapter

    var status = "f"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setting sliding panel
        map_sliding_layout.setDragView(R.layout.bottom_sheet_map)
        map_sliding_layout.isNestedScrollingEnabled = true

        placeDatas.clear()
        personDatas.clear()

        //지도 띄우기
//        val mapView = MapView(activity)
//        val mapViewContainer = map_view as ViewGroup
//        mapViewContainer.addView(mapView)

        //Adapter Initialization
        mapPersonAdapter = MapPersonAdapter(view.context,
            object : MapPersonViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(
                        context,
                        personDatas[position].txt_personName,
                        Toast.LENGTH_SHORT
                    ).show()

//                    setMarker(mapView, personDatas[position].txt_personName, markerData)
                }

            })
        mapPlaceAdapter = MapPlaceAdapter(view.context,
            object : MapPlaceViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        //Attach adapter to Recyclerview
        bottom_sheet_rv_person.adapter = mapPersonAdapter
        bottom_sheet_rv_person.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        bottom_sheet_rv_place.adapter = mapPlaceAdapter
        bottom_sheet_rv_place.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // friend button click event - set friendData
        frag_map_btn_friend.setOnClickListener {
            status = "f"
            frag_map_btn_friend.setBackgroundResource(R.drawable.bg_faded_orange_round)
            frag_map_btn_group.setBackgroundResource(R.drawable.bg_white_three_round)
            loadFriendDatas()
        }
        // group button click event - set GroupData
        frag_map_btn_group.setOnClickListener {
            status = "g"
            frag_map_btn_friend.setBackgroundResource(R.drawable.bg_white_three_round)
            frag_map_btn_group.setBackgroundResource(R.drawable.bg_faded_orange_round)
            loadGroupDatas()
        }

        frag_map_btn_plus.setOnClickListener {
            if(status == "f"){
                val intent = Intent(context, CreateFriendActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(context, CreateGroupActivity::class.java)
                startActivity(intent)
            }
        }

        //default Data Setting
        loadFriendDatas()
        loadPlaceDatas()
        loadMarkerDatas()
    }

    private fun loadFriendDatas() {
        personDatas.clear()
        personDatas.apply {
            add(
                PersonListData(
                    img_person = "https://blog.kakaocdn.net/dn/bDfAQw/btqD2bD1qbY/KekKgYpWSAZCtsRjQC0kS0/img.jpg",
                    txt_personName = "동원참치"
                )
            )
            add(
                PersonListData(
                    img_person = "https://newsimg.sedaily.com/2018/02/13/1RVOS58842_1.jpg",
                    txt_personName = "강동원"
                )

            )
            add(
                PersonListData(
                    img_person = "https://i.pinimg.com/originals/c8/05/c7/c805c7ab8253e96982fa67757d580920.png",
                    txt_personName = "박보검"
                )
            )
        }

        mapPersonAdapter.datas = personDatas
        mapPersonAdapter.notifyDataSetChanged()

    }

    private fun loadMarkerDatas() {
        markerData.apply {
            add(MarkerData(37.628214, 127.072165, "1988옛날통닭", personName = "동원참치"))
            add(MarkerData(37.628214, 127.072165, "1988옛날통닭", personName = "박보검"))

            add(MarkerData(37.627475, 127.077132, "세븐일레븐", personName = "박보검"))
            add(MarkerData(37.627475, 127.077132, "세븐일레븐", personName = "강동원"))

            add(MarkerData(37.625470, 127.073334, "GS25", personName = "강동원"))
            add(MarkerData(37.625470, 127.073334, "GS25", personName = "동원참치"))
            add(MarkerData(37.625470, 127.073334, "GS25", personName = "박보검"))

            add(MarkerData(37.624979, 127.077868, "라라브레드", personName = "박보검"))
            add(MarkerData(37.624979, 127.077868, "라라브레드", personName = "강동원"))
            add(MarkerData(37.624979, 127.077868, "라라브레드", personName = "동원참치"))

            add(MarkerData(37.618690, 127.075851, "요거프레소", personName = "강동원"))
            add(MarkerData(37.623021, 127.079237, "교촌치킨 공릉 1호점", personName = "강동원"))
        }
    }

    private fun loadPlaceDatas() {

        placeDatas.apply {
            add(
                PlaceData(
                    img_place = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김지현외 4,345",
                    txt_thumbDown = "34"
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

        mapPlaceAdapter.datas = placeDatas
        mapPlaceAdapter.notifyDataSetChanged()

    }

    private fun loadGroupDatas() {
        personDatas.clear()
        personDatas.apply {
            add(
                PersonListData(
                    img_person = "https://t1.daumcdn.net/cfile/tistory/99648F4C5D2D347914",
                    txt_personName = "수플레"
                )
            )
            add(
                PersonListData(
                    img_person = "data:image/jpeg;base64,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",
                    txt_personName = "SWU"
                )
            )
            add(
                PersonListData(
                    img_person = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2366B84652A2DD3132",
                    txt_personName = "토이스토리"
                )
            )
        }

        mapPersonAdapter.datas = personDatas
        mapPersonAdapter.notifyDataSetChanged()

    }

    private fun setMarker(mapView: MapView, personName: String, markerData: ArrayList<MarkerData>) {

        val array = ArrayList<MapPOIItem>()
        Log.e("1", array.toString())

        //marker initailization
        for (i in 0 until array.size) {
            mapView.removePOIItem(array[i])
            array[i].mapPoint = null
            array[i].markerType = null

            mapView.removeAllPOIItems()

        }


        Log.e("2", array.toString())


        // set map markders
        for (i in 0 until markerData.size) {
            if (personName == markerData[i].personName) {
                personMarkerData.add(markerData[i])
                Log.e("3 - $personName", personMarkerData.toString())

            }
        }

        //마커 띄우기
        array.clear()
        Log.e("4", array.toString())


        for (i in 0 until personMarkerData.size) {

            val customMarker = MapPOIItem()

            customMarker.itemName = personMarkerData[i].storeName
            val mapPoint = MapPoint.mapPointWithGeoCoord(
                personMarkerData[i].latitude,
                personMarkerData[i].longitude
            )
            customMarker.mapPoint = mapPoint
            customMarker.markerType = MapPOIItem.MarkerType.CustomImage // 마커타입을 커스텀 마커로 지정.
            customMarker.customImageResourceId = R.drawable.ic_map_friend_marker // 마커 이미지.

            array.add(customMarker)
        }

        Log.e("5", array.toString())

        do {
            mapView.removeAllPOIItems()
            for( i in 0 until array.size){
                mapView.addPOIItem(array[i])
            }
            break
        }while (true)



    }


}