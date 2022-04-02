package com.example.todo_application.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todo_application.view.fragment.CalenderFragment
import com.example.todo_application.view.fragment.DoneFragment
import com.example.todo_application.view.fragment.TodoFragment

class ViewPagerAdapter (fragment: FragmentActivity) :FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return  when (position) {
            0 -> TodoFragment()
            1 -> CalenderFragment()
            else -> DoneFragment()
        }
    }

}