package com.example.suffle.ui.bottomTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.suffle.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
        setTabBar()
    }

    private fun setTabBar(){
        val bottomTabBar: View = LayoutInflater.from(this).inflate(R.layout.tab_layout, null)
        act_main_bottomTab.run {

            addTab(
                    this.newTab()
                            .setCustomView(bottomTabBar.findViewById(R.id.cl_tab_home) as ConstraintLayout)
            )
            addTab(
                    this.newTab()
                            .setCustomView(bottomTabBar.findViewById(R.id.cl_tab_map) as ConstraintLayout)
            )
            addTab(
                    this.newTab()
                            .setCustomView(bottomTabBar.findViewById(R.id.cl_tab_feed) as ConstraintLayout)
            )
            addTab(
                    this.newTab()
                            .setCustomView(bottomTabBar.findViewById(R.id.cl_tab_mypage) as ConstraintLayout)
            )

            // 인디케이터 없애기
            setSelectedTabIndicator(0)
        }
    }

    private fun setAdapter() {
        act_main_viewpager.adapter =
            BottomTabAdapter(
                supportFragmentManager,
                4
            )

        act_main_viewpager.offscreenPageLimit = 3
        act_main_viewpager.currentItem = 0

        act_main_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(act_main_bottomTab))

        act_main_bottomTab!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                act_main_viewpager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }
}