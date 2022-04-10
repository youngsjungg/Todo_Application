package com.example.todo_application.view.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.todo_application.R
import com.example.todo_application.databinding.DialogTodoBinding

class CustomDialog(context: Context, customDialogInterface: CustomDialogInterface)
    : Dialog(context) {

    private lateinit var  binding: DialogTodoBinding
    private var customDialogInterface : CustomDialogInterface = customDialogInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editMemo = binding.etTodo

        //배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.btnConfirm.setOnClickListener {
            val memo = editMemo.text.toString()

            if (TextUtils.isEmpty(memo)) {
                Toast.makeText(context, "메모를 입력해주세요 . " , Toast.LENGTH_SHORT).show()
            }else{
                customDialogInterface.onOkButtonClicked(memo)
                dismiss()
            }
        }
        binding.btnCancle.setOnClickListener { dismiss() }




    }
}

