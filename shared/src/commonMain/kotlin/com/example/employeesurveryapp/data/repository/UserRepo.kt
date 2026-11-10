package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.User

class UserRepository {

    fun getUsers(): List<User> {

        return listOf(
            User(
                userId = 1,
                email = "malthe@test.dk",
                firstName = "Malthe",
                lastName = "Bruhn",
                passwordHash = "password123",
                isActive = true,
                roleId = 1
            ),
            User(
                userId = 2,
                email = "test@test.dk",
                firstName = "Test",
                lastName = "Bruger",
                passwordHash = "password123",
                isActive = true,
                roleId = 2
            )
        )
    }

    fun getUserById(userId: Int): User? {
        return getUsers().find { it.userId == userId }
    }
}