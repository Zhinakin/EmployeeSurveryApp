package com.example.employeesurveryapp.data.model

data class Notification(
    val notificationId: Int = 0,
    val userId: Int,
    val notificationTitle: String,
    val notificationMessage: String,
    val createdDate: String,
    val readDate: String?
)