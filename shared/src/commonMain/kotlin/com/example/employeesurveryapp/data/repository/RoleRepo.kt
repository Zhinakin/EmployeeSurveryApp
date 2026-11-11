package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.Role

class RoleRepository {

    fun getRoles(): List<Role> {

        return listOf(

            Role(
                roleId = 1,
                roleName = "Admin"
            ),

            Role(
                roleId = 2,
                roleName = "Employee"
            )
        )
    }

    fun getRoleById(roleId: Int): Role? {

        return getRoles().find {
            it.roleId == roleId
        }
    }
}