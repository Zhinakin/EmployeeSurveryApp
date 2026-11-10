package com.example.employeesurveryapp.data.model

data class FeedbackMessage(
    val feedbackId: Int = 0,
    val surveyId: Int,
    val createdByUserId: Int,
    val messageText: String,
    val createdDate: String
)