package com.example.todo_application.one

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo_application.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}