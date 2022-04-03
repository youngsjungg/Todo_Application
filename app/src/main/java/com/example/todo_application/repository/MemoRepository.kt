package com.example.todo_application.repository

import androidx.room.Query
import com.example.todo_application.data.Memo
import com.example.todo_application.data.MemoDao
import kotlinx.coroutines.flow.Flow

class MemoRepository(private val memoDao : MemoDao) {
    val readAllData : Flow<List<Memo>> = memoDao.readAllData()

    suspend fun addUser(memo: Memo) {
        memoDao.addUser(memo)
    }
    suspend fun updataUser(memo: Memo) {
        memoDao.updataUser(memo)
    }
    suspend fun deleteUser(memo: Memo) {
        memoDao.deleteUser(memo)
    }

    fun searchDatabase(searchQuery: String) : Flow<List<Memo>> {
        return memoDao.searchDatabase(searchQuery)
    }
}