package com.example.todo_application.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_application.data.Memo
import com.example.todo_application.databinding.TodoItemBinding
import com.example.todo_application.viewmodel.MemoViewModel

class TodoAdapter(private val memoViewModel: MemoViewModel) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    private var memoList = emptyList<Memo>()
    class ViewHolder(val binding: TodoItemBinding) :RecyclerView.ViewHolder(binding.root)
    {
        fun bind(currentMemo: Memo, memoViewModel: MemoViewModel){
            binding.memo  = currentMemo
            
            //체크리스트 초기화 - 중복 오류 방지 
            binding.btnCheck.setOnCheckedChangeListener(null)
            
            //메모 체크 시 체크 데이터 업뎃 
            binding.btnCheck.setOnCheckedChangeListener { _, check ->
                if (check) {
                    val memo = Memo(currentMemo.id , true, currentMemo.content,
                        currentMemo.year, currentMemo.month , currentMemo.day)
                    memoViewModel.updataMemo(memo)
                }else{
                    val memo =  Memo(currentMemo.id , false, currentMemo.content,
                        currentMemo.year, currentMemo.month , currentMemo.day)
                    memoViewModel.updataMemo(memo)
                }
            }
            binding.btnDelete.setOnClickListener {
                memoViewModel.deleteMemo(currentMemo)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(memoList[position], memoViewModel)
//        val currentItem = memoList[position]
//        val currentContent = currentItem.content
//        val currentCheck = currentItem.check
//        val currentYear = currentItem.year
//        val currentMonth = currentItem.month
//        val currentDay = currentItem.day
//
//        val s_currentYear = currentYear.toString()
//        var s_currentMonth = currentMonth.toString()
//        var s_currentDay = currentDay.toString()
//
//        if (currentMonth < 10) s_currentMonth = "0$currentMonth"
//        if (currentDay < 10) s_currentDay = "0$currentDay"
//
//        holder.binding.btnCheck.text = currentContent
//        holder.binding.tvDate.text = "$s_currentYear/$s_currentMonth/$s_currentDay"


//        holder.binding.btnCheck.text = currentContent
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    //메모 리스트 갱신
      fun setData(memo : List<Memo>) {
        memoList = memo
        notifyDataSetChanged()
    }

    //아이템에 아이디 설정 : 깜빡이는 현상방지
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}