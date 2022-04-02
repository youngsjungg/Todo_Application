package com.example.todo_application.data

import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface MemoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addUser(memo: Memo)

    @Update
    suspend fun  updataUser(memo: Memo)

    @Delete
    suspend fun deleteUser(memo: Memo)

    @Query("SELECT * FROM Memo ORDER BY ID ASC")
    fun readAllData() : Flow<List<Memo>>

    @Query("SELECT * FROM Memo WHERE content LIKE : searchQuery")
    fun  searchDatabase(searchQuery: String) : Flow<List<Memo>>

}