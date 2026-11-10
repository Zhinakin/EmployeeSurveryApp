package com.example.employeesurveryapp.data.model

import com.example.employeesurveryapp.data.model.QuestionType

data class Question(
    val questionId: Int = 0,
    val surveyId: Int,
    val questionType: QuestionType,
    val questionText: String,
    val displayOrder: Int,
    val isRequired: Boolean
)