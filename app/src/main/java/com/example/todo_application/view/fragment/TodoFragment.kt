package com.example.todo_application.view.fragment

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_application.R
import com.example.todo_application.adapter.TodoAdapter
import com.example.todo_application.data.Memo
import com.example.todo_application.databinding.FragmentTodoBinding
import com.example.todo_application.viewmodel.MemoViewModel

class TodoFragment : Fragment() {

    private var binding : FragmentTodoBinding? = null
    private val memoViewModel : MemoViewModel by viewModels()
    private val adapter : TodoAdapter by lazy { TodoAdapter()  }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //상단 메뉴 추가
        binding = FragmentTodoBinding.inflate(inflater, container,false)

        setHasOptionsMenu(true)
        binding!!.btnAdd.setOnClickListener {
            Toast.makeText(activity,"ㅌㅔ스트 ", Toast.LENGTH_SHORT)
            onFabClicked()
        }
        //아이템을 가로로 하나씩 보여줌
        binding!!.todoRecycelr.layoutManager = LinearLayoutManager(activity ,LinearLayoutManager.VERTICAL,
                false)
        binding!!.todoRecycelr.adapter = adapter


        //리스트를 관찰하여 변경시 어댑터에 전달
        memoViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
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

   fun onFabClicked() {
       val memo = Memo(false , "테스트")
       memoViewModel.addUser(memo)

   }

}