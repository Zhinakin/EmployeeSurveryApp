package com.example.employeesurveryapp.data.model

data class User(
    val userId: Int = 0,
    val email: String,
    val firstName: String,
    val lastName: String,
    val passwordHash: String,
    val isActive: Boolean,
    val roleId: Int
)