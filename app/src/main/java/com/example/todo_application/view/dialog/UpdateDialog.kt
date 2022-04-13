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

class UpdateDialog(context: Context , updateDialogInterface: UpdateDialogInterface) : Dialog(context) {

    //activity에서 interface를 받아옴
    private var updateDialogInterface : UpdateDialogInterface = updateDialogInterface
    private lateinit var  binding: DialogTodoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogTodoBinding.inflate(layoutInflater)
        setContentView(R.layout.dialog_todo)

        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        var et_memo = binding.etTodo.text

        binding.btnConfirm.setOnClickListener {
            val content = et_memo.toString()

            //입력 안했을 때
            if (TextUtils.isEmpty(content)) {
                Toast.makeText(context, "수정할 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                //메모 수정
                updateDialogInterface.onOkButtonClick(content)
                dismiss()
            }
        }
        binding.btnCancle.setOnClickListener { dismiss() }


    }
}