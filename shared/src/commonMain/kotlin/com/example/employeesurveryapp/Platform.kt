package com.example.employeesurveryapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform