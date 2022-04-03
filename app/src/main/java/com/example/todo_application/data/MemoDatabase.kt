package com.example.todo_application.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1, exportSchema = false )
abstract class MemoDatabase : RoomDatabase() {

    abstract fun memoDao() : MemoDao

    companion object{
        @Volatile
        private var instance : MemoDatabase? = null

        fun getDatabase(context: Context) : MemoDatabase? {
            if (instance == null) {
                synchronized(MemoDatabase::class){
                    instance  = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java,
                        "memo_database"
                    ).build()
                }
            }
            return instance

        }
    }
}