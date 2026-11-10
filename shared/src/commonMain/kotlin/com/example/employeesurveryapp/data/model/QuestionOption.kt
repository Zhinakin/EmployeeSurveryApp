package com.example.employeesurveryapp.data.model

data class QuestionOption(
    val optionId: Int = 0,
    val questionId: Int,
    val optionText: String,
    val displayOrder: Int
)