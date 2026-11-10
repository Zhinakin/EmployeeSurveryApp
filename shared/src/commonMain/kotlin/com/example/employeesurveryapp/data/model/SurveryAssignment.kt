package com.example.employeesurveryapp.data.model

data class SurveyAssignment(
    val assignmentId: Int = 0,
    val surveyId: Int,
    val userId: Int,
    val assignedDate: String,
    val completedDate: String?
)