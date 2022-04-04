package com.example.todo_application.adapter

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHolder, position: Int) {
        val currentItem = memoList[position]
        val currentContent = currentItem.content
        val currentCheck = currentItem.check

        holder.binding.btnCheck.text = currentContent
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