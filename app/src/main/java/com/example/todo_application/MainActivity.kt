package com.example.todo_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo_application.databinding.ActivityMainBinding
import com.example.todo_application.one.MainActivity2

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTodo1.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
    }
}