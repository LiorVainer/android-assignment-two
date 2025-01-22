package com.example.android_assignment_two.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_assignment_two.R
import com.example.android_assignment_two.model.Model

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentId = intent.getStringExtra("STUDENT_ID")
        val students = Model.shared.students;
        val student = students.find { it.id == studentId }

        val nameText: EditText = findViewById(R.id.edit_student_activity_name_edit_text)
        val idText: EditText = findViewById(R.id.edit_student_activity_id_edit_text)

        val saveButton: Button = findViewById(R.id.edit_student_activity_save_button);
        val deleteButton: Button = findViewById(R.id.edit_student_activity_delete_button);
        val cancelButton: Button = findViewById(R.id.edit_student_activity_cancel_button);

        student?.let {
            nameText.setText(it.name)
            idText.setText(it.id)
        }

        saveButton.setOnClickListener {
            val newName = nameText.text.toString()
            val newId = idText.text.toString()

            if (newName.isNotEmpty() && newId.isNotEmpty()) {
                student?.name = newName
                student?.id = newId

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        cancelButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish();
        }

        deleteButton.setOnClickListener {
            students.remove(student)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}