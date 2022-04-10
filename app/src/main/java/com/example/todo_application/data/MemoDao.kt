package com.example.todo_application.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface MemoDao {

    //동일아이디 무시
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMemo(memo: Memo)

    @Update
    suspend fun updataMemo(memo: Memo)

    @Delete
    suspend fun deleteMemo(memo: Memo)

    @Query("SELECT * FROM Memo ORDER BY Id ASC")
    fun readAllData() : Flow<List<Memo>>

    @Query("SELECT * FROM Memo WHERE content LIKE :searchQuery")
    fun  searchDatabase(searchQuery: String) : Flow<List<Memo>>

}