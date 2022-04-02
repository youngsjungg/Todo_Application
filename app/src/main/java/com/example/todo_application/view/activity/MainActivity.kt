package com.example.todo_application.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo_application.adapter.ViewPagerAdapter
import com.example.todo_application.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //탭 선택되었을 때

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //이미 선택된 탭이 다시 선택되었을 때
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //탭이 선택되지 않은 상태로 변경되었을 때

            }
            
        })
        binding.pager.adapter  = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab , position ->
            when(position) {
                0 -> tab.text = "Todo"
                1 -> tab.text = "CalenderFragment"
                2 -> tab.text = "DoneFragment"
            }

        }.attach()


    }
}