package com.example.android_assignment_two.model

class Model private constructor() {
    val students: MutableList<Student> = mutableListOf(
        Student(
            name = "Lior Vainer",
            id = "322780941",
            avatarUrl = "",
            isChecked = false
        ),
        Student(
            name = "Rom Pollak",
            id = "325106409",
            avatarUrl = "",
            isChecked = false
        )
    )

    companion object {
        val shared = Model()
    }
}