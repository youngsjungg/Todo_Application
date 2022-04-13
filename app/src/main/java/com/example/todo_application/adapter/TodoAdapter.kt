package com.example.todo_application.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_application.data.Memo
import com.example.todo_application.databinding.FragmentTodoBinding
import com.example.todo_application.databinding.TodoItemBinding
import com.example.todo_application.viewmodel.MemoViewModel

class TodoAdapter :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    private var memoList = emptyList<Memo>()
    class ViewHolder(val binding: TodoItemBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = memoList[position]
        val currentContent = currentItem.content
//        val currentCheck = currentItem.check
        val currentYear = currentItem.year
        val currentMonth = currentItem.month
        val currentDay = currentItem.day

        val s_currentYear = currentYear.toString()
        var s_currentMonth = currentMonth.toString()
        var s_currentDay = currentDay.toString()

        if (currentMonth < 10) s_currentMonth = "0$currentMonth"
        if (currentDay < 10) s_currentDay = "0$currentDay"

        holder.binding.btnCheck.text = currentContent
        holder.binding.tvDate.text = "$s_currentYear/$s_currentMonth/$s_currentDay"


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

}