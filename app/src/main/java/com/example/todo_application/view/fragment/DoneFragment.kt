package com.example.todo_application.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_application.adapter.TodoAdapter
import com.example.todo_application.databinding.FragmentDoneBinding
import com.example.todo_application.databinding.FragmentTodoBinding
import com.example.todo_application.viewmodel.MemoViewModel

class DoneFragment : Fragment() {

    private var binding : FragmentDoneBinding? = null
    private val memoViewModel : MemoViewModel by viewModels()
    private val adapter : TodoAdapter by lazy { TodoAdapter(memoViewModel) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoneBinding.inflate(inflater, container,false)

        adapter.setHasStableIds(true)

        binding!!.doneRecycelr.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL ,false
        )
        binding!!.doneRecycelr.adapter = adapter

        //리스트 관찰하여 변경시 어댑터에 전달
        memoViewModel.readDoneData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        return  binding!!.root
    }
}