package com.example.todo_application.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey(autoGenerate = true)
    var id :Int= 0,
    val check : Boolean,
    val content : String
)