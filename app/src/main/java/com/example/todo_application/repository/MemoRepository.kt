package com.example.todo_application.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.todo_application.data.Memo
import com.example.todo_application.data.MemoDao
import kotlinx.coroutines.flow.Flow
import java.time.Year

class MemoRepository(private val memoDao : MemoDao) {
    val readAllData : Flow<List<Memo>> = memoDao.readAllData()

    suspend fun addMemo(memo: Memo) {
        memoDao.addMemo(memo)
    }
    suspend fun updataMemo(memo: Memo) {
        memoDao.updataMemo(memo)
    }
    suspend fun deleteMemo(memo: Memo) {
        memoDao.deleteMemo(memo)
    }

    fun searchDatabase(searchQuery: String) : Flow<List<Memo>> {
        return memoDao.searchDatabase(searchQuery)
    }

    fun readDateData(year: Int, month : Int , day : Int)  :Flow<List<Memo>>  {
        return memoDao.readDateData(year, month, day)

    }
}