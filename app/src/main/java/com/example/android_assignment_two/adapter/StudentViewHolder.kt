package com.example.android_assignment_two.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment_two.R
import com.example.android_assignment_two.model.Student

class StudentViewHolder(
    itemView: View,
    private val onStudentClick: (Student) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.student_row_name_text_view)
    private val idTextView: TextView = itemView.findViewById(R.id.student_row_id_text_view)
    private val studentCheckBox: CheckBox = itemView.findViewById(R.id.student_row_check_box)

    private var student: Student? = null

    init {
        studentCheckBox.setOnClickListener {
            student?.let {
                it.isChecked = studentCheckBox.isChecked
            }
        }

        itemView.setOnClickListener {
            student?.let { onStudentClick(it) }
        }
    }

    fun bind(student: Student) {
        this.student = student
        nameTextView.text = student.name
        idTextView.text = student.id
        studentCheckBox.isChecked = student.isChecked
    }
}
