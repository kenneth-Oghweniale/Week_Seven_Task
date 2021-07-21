package com.kenneth.week_seven_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kenneth.week_seven_task.databinding.ActivityStudentAddBinding


class StudentAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentAddBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //instantiating viewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.idBtnPost.setOnClickListener {
            addStudent()
        }

    }

    private fun addStudent() {
        val name = binding.idEdtName.text.toString()
        val seat = binding.idEdtSeat.text.toString()
        val classNames = binding.idEdtClass.text.toString()

        if (name.isNotEmpty() && seat.isNotEmpty() && classNames.isNotEmpty()) {
            //adding new student to server
            val newStudent = Student(name, seat, classNames)
            viewModel.addStudent(newStudent)
            Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
}