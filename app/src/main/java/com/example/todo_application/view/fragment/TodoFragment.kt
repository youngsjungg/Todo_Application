package com.example.todo_application.view.fragment

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.todo_application.R
import com.example.todo_application.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {

    private var binding : FragmentTodoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //상단 메뉴 추가
        setHasOptionsMenu(true)
        binding = FragmentTodoBinding.inflate(inflater, container,false)
        return  binding!!.root
    }

    //서치바 추가
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}