package com.example.employeesurveryapp.data.model

data class Survey(
    val surveyId: Int = 0,
    val surveyYearId: Int,
    val surveyName: String,
    val startDate: String?,
    val endDate: String?,
    val isActive: Boolean
)