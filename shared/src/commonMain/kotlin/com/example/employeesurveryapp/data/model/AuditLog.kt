package com.example.employeesurveryapp.data.model

data class AuditLog(
    val auditId: Int = 0,
    val userId: Int?,
    val eventType: String,
    val eventDescription: String,
    val eventDate: String
)