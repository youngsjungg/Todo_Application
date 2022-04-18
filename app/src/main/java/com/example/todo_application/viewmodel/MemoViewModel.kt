package com.example.todo_application.viewmodel

import android.app.Application
import android.app.DownloadManager
import androidx.lifecycle.*
import com.example.todo_application.data.Memo
import com.example.todo_application.data.MemoDatabase
import com.example.todo_application.repository.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Memo>>
    val readDoneData : LiveData<List<Memo>>

    private val repository : MemoRepository

    //get set
    private var _currentData = MutableLiveData<List<Memo>>()
    val currentData : LiveData<List<Memo>>
        get() = _currentData

    init {
        val memoDao = MemoDatabase.getDatabase(application)!!.memoDao()
        repository = MemoRepository(memoDao)
        readAllData = repository.readAllData.asLiveData()
        readDoneData = repository.readDoneData.asLiveData()
    }

    fun addMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMemo(memo)
        }
    }

    fun updataMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updataMemo(memo)
        }
    }

    fun deleteMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
          repository.deleteMemo(memo)
        }
    }
    fun searchDatabase(searchQuery: String) : LiveData<List<Memo>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }
    fun readDateData(year: Int , month : Int , day : Int)  {
        viewModelScope.launch(Dispatchers.IO) {
            val tmp = repository.readDateData(year, month, day)
            _currentData.postValue(tmp)

        }
    }
}