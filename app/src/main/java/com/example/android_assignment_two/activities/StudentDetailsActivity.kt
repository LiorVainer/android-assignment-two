package com.example.android_assignment_two.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_assignment_two.R
import com.example.android_assignment_two.model.Student
import com.example.android_assignment_two.model.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        // Get the student ID passed via intent
        val studentId = intent.getStringExtra("STUDENT_ID")
        val student: Student? = Model.shared.students.find { it.id == studentId }

        // Find views
        val nameText: TextView = findViewById(R.id.student_details_activity_text_name)
        val idText: TextView = findViewById(R.id.student_details_activity_id_text)
        val picture: ImageView = findViewById(R.id.student_details_activity_picture)
        val statusText: TextView = findViewById(R.id.student_details_activity_status_text)
        val editButton: Button = findViewById(R.id.student_details_activity_button_edit)

        student?.let {
            nameText.text = it.name
            idText.text = "ID: ${it.id}"
            picture.setImageResource(R.drawable.avatar) // Replace with your placeholder drawable
            statusText.text = if (it.isChecked) "Checked: true" else "Checked: false"
        }

        editButton.setOnClickListener {
             val intent = Intent(this, EditStudentActivity::class.java)
             intent.putExtra("STUDENT_ID", studentId)
             startActivity(intent)
        }

        // Enable back button in toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
