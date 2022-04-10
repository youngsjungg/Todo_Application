package com.example.todo_application.repository

import androidx.room.Query
import com.example.todo_application.data.Memo
import com.example.todo_application.data.MemoDao
import kotlinx.coroutines.flow.Flow

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
}