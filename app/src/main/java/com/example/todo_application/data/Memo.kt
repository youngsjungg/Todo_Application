package com.example.todo_application.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    val check : Boolean,
    val content : String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
