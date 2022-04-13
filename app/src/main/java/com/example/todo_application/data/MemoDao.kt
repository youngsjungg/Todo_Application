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


    // 큰 날짜부터 출력
    @Query("SELECT * FROM Memo ORDER BY year DESC, month DESC, day DESC, id DESC")
    fun readAllData() : Flow<List<Memo>>

    // 날짜 정보를 입력받아 그 날짜에 해당하는 메모만 반환
    @Query("SELECT * FROM Memo WHERE year = :year AND month = :month AND day = :day ORDER BY id DESC")
    fun readDateData(year : Int, month : Int, day : Int) : Flow<List<Memo>>

    @Query("SELECT * FROM Memo WHERE content LIKE :searchQuery")
    fun  searchDatabase(searchQuery: String) : Flow<List<Memo>>

}