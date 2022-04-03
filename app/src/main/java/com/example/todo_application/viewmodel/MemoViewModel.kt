package com.example.todo_application.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.todo_application.data.Memo
import com.example.todo_application.data.MemoDatabase
import com.example.todo_application.repository.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Memo>>
    private val repository : MemoRepository

    init {
        val memoDao = MemoDatabase.getDatabase(application)!!.memoDao()
        repository = MemoRepository(memoDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addUser(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(memo)
        }
    }

    fun updataUser(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updataUser(memo)
        }
    }
}