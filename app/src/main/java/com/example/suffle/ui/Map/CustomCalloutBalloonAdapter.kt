/*
package com.example.suffle.ui.Map

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.ImageView
import com.example.suffle.R
import net.daum.mf.map.api.CalloutBalloonAdapter
import net.daum.mf.map.api.MapPOIItem

// CalloutBalloonAdapter 인터페이스 구현
class CustomCalloutBalloonAdapter : CalloutBalloonAdapter {


    public CustomCalloutBalloonAdapter() {
        val mCalloutBalloon = LayoutInflater.inflate(R.layout.fragment_map, false)
    }

    override fun getPressedCalloutBalloon(p0: MapPOIItem?): View? {
        return null
    }

    override fun getCalloutBalloon(p0: MapPOIItem?): View {
        ((ImageView) mCalloutBalloon.findViewById(R.id.badge)).setImageResource(R.drawable.ic_launcher);
        ((TextView) mCalloutBalloon.findViewById(R.id.title)).setText(poiItem.getItemName());
        ((TextView) mCalloutBalloon.findViewById(R.id.desc)).setText("Custom CalloutBalloon");
        return mCalloutBalloon;    }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    // 구현한 CalloutBalloonAdapter 등록
    mMapView.setCalloutBalloonAdapter(new CustomCalloutBalloonAdapter());
    ...
}*/
