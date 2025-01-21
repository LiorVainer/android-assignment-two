package com.example.android_assignment_two.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment_two.R
import com.example.android_assignment_two.adapter.StudentsRecyclerAdapter
import com.example.android_assignment_two.model.Model

class MainActivity : AppCompatActivity() {

    private lateinit var studentsRecyclerView: RecyclerView
    private lateinit var addStudentButton: Button
    private lateinit var studentsAdapter: StudentsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentsRecyclerView = findViewById(R.id.students_recycler_view)
        addStudentButton = findViewById(R.id.add_student_button)

        studentsAdapter = StudentsRecyclerAdapter(Model.shared.students) { selectedStudent ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("STUDENT_ID", selectedStudent.id)
            startActivity(intent)
        }
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        studentsRecyclerView.adapter = studentsAdapter

        // TODO: Implement add student functionality
        addStudentButton.setOnClickListener {
            // val intent = Intent(this, AddStudentActivity::class.java)
            // startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        studentsAdapter.notifyDataSetChanged()
    }
}
