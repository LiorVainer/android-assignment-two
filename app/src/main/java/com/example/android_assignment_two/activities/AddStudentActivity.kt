package com.example.android_assignment_two.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_assignment_two.R
import com.example.android_assignment_two.model.Model
import com.example.android_assignment_two.model.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button)

        val nameEditText: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val idEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text)

        cancelButton.setOnClickListener {
            finish()
        }

        val students = Model.shared.students

        saveButton.setOnClickListener {
            val newName = nameEditText.text.toString()
            val newId = idEditText.text.toString()
            val existingStudent = students.find { it.id == newId }

            if (newName.isEmpty() || newId.isEmpty()) {
                showError("Name and ID cannot be empty")
                return@setOnClickListener
            }

            if (existingStudent != null) {
                showError("A student with this ID already exists")
                return@setOnClickListener
            }

            val newStudent =
                Student(nameEditText.text.toString(), idEditText.text.toString(), "", false)
            students.add(newStudent)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun showError(message: String) {
        android.widget.Toast
            .makeText(this, message, android.widget.Toast.LENGTH_SHORT)
            .show()
    }
}
