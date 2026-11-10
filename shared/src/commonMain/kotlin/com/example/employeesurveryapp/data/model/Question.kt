package com.example.employeesurveryapp.data.model

data class Question(
    val questionId: Int = 0,
    val surveyId: Int,
    val questionTypeId: Int,
    val questionText: String,
    val displayOrder: Int,
    val isRequired: Boolean
)