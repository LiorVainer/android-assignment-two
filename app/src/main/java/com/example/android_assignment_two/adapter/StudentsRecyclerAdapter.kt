package com.example.android_assignment_two.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment_two.R
import com.example.android_assignment_two.model.Student

class StudentsRecyclerAdapter(
    private val students: MutableList<Student>?,
    private val onStudentClick: (Student) -> Unit,
) : RecyclerView.Adapter<StudentViewHolder>() {
    override fun getItemCount(): Int = students?.size ?: 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): StudentViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_list_row,
                parent,
                false,
            )
        return StudentViewHolder(itemView) { student ->
            onStudentClick(student)
        }
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int,
    ) {
        students?.get(position)?.let { student ->
            holder.bind(student)
        }
    }
}
