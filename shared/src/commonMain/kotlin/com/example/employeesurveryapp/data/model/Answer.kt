package com.example.employeesurveryapp.data.model

data class Answer(
    val answerId: Int = 0,
    val assignmentId: Int,
    val questionId: Int,
    val answerValue: String?,
    val answerDate: String
)