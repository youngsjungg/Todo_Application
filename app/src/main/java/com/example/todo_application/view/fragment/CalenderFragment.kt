package com.example.todo_application.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_application.adapter.TodoAdapter
import com.example.todo_application.data.Memo
import com.example.todo_application.databinding.FragmentCalenderBinding
import com.example.todo_application.view.dialog.CustomDialog
import com.example.todo_application.view.dialog.CustomDialogInterface
import com.example.todo_application.viewmodel.MemoViewModel

class CalenderFragment : Fragment(), CustomDialogInterface {

    private var binding : FragmentCalenderBinding? = null
    //viewmodel 연결
    private val memoViewModel : MemoViewModel by viewModels()
    //Adapter 선언
    private val adapter : TodoAdapter by lazy { TodoAdapter(memoViewModel) }

    private var year = 0
    private var month = 0
    private var day = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalenderBinding.inflate(inflater,container,false)

        adapter.setHasStableIds(true)
        binding!!.recyclerCal.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL, false)
        binding!!.recyclerCal.adapter = adapter


        binding!!.calendar.setOnDateChangeListener { calendarView, year, month, day ->
           //날짜 선택시 그 날의 정보할당
            this.year = year
            this.month = month+1
            this.day = day

            binding!!.tvSelectDate.text = "${this.year}/${this.month}/${this.day}"

            //리스트를 관찬하여 변경되면 어댑터에 전달
            memoViewModel.readDateData(this.year, this.month, this.day)

        }
        //메모 데이터 수정시 날짜 데이터 불러옴
        memoViewModel.readAllData.observe(viewLifecycleOwner, {
            memoViewModel.readDateData(year, month, day)
        })
        //현재 날짜 데이터 리스트를 관찰하여 변경시 어댑터에 전달
        memoViewModel.currentData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        binding!!.btnAdd.setOnClickListener {
            onFabClicked()
        }


        return binding!!.root
    }
    private fun onFabClicked() {

        val customDialog = CustomDialog(requireActivity() , this)
        customDialog.show()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onOkButtonClicked(content: String) {
        //선택된 날짜로 메모 추가
        val memo = Memo(0,false, content, year, month, day)
        memoViewModel.addMemo(memo)
        Toast.makeText(activity, "추가", Toast.LENGTH_SHORT).show()


    }
}