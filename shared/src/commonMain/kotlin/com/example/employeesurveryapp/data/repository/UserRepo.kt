package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.User

class UserRepository {

    fun getUsers(): List<User> {

        return listOf(
            User(
                userId = 1,
                email = "admin@test.dk",
                firstName = "Malthe",
                lastName = "Bruhn",
                passwordHash = "admin123",
                isActive = true,
                roleId = 1
            ),
            User(
                userId = 2,
                email = "test1@test.dk",
                firstName = "Test1",
                lastName = "Bruger",
                passwordHash = "password123",
                isActive = true,
                roleId = 2
            ),
            User(
                userId = 3,
                email = "test2@test.dk",
                firstName = "Test2",
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

    fun login(
        email: String,
        password: String
    ): User? {

        return getUsers().find {
            it.email == email &&
                    it.passwordHash == password
        }
    }
}