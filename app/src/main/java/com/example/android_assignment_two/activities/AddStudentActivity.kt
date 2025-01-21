package com.example.android_assignment_two.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_assignment_two.R
import com.example.android_assignment_two.model.Student
import com.example.android_assignment_two.model.Model

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button);
        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button);

        val nameEditText: EditText = findViewById(R.id.add_student_activity_name_edit_text);
        val idEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text);

        val savedMessageTextView: TextView = findViewById(R.id.add_student_activity_save_message_text_view);

        cancelButton.setOnClickListener {
            finish();
        }

        val students = Model.shared.students;

        saveButton.setOnClickListener {
            val newStudent = Student(idEditText.text.toString(), nameEditText.text.toString(),"", false)
            students.add(newStudent);
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}