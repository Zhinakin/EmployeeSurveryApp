package com.example.employeesurveryapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.employeesurveryapp.data.model.User
import com.example.employeesurveryapp.screens.SurveyDetailScreen
import com.example.employeesurveryapp.screens.SurveyListScreen
import org.jetbrains.compose.resources.painterResource
import com.example.employeesurveryapp.screens.LoginScreen
import com.example.employeesurveryapp.data.repository.UserRepository
import com.example.employeesurveryapp.screens.AdminDashboardScreen

import employeesurveryapp.shared.generated.resources.Res
import employeesurveryapp.shared.generated.resources.compose_multiplatform

@Composable
fun App() {

    var currentUserLoggedIn by remember {
        mutableStateOf(false)
    }

    var selectedSurveyId by remember {
        mutableStateOf<Int?>(null)
    }

    var currentUser by remember {
        mutableStateOf<User?>(null)
    }

    if (!currentUserLoggedIn) {

        LoginScreen(
            onLogin = { email, password ->

                val userRepository = UserRepository()

                val user =
                    userRepository.login(email, password)

                if (user != null) {
                    currentUser = user
                    currentUserLoggedIn = true
                }
            }
        )

    } else {

        if (currentUser!!.roleId == 1) {

            AdminDashboardScreen(
                onLogout = {

                    currentUser = null
                    currentUserLoggedIn = false
                    selectedSurveyId = null

                }
            )

        }

        else {
            if (selectedSurveyId == null) {

                SurveyListScreen(
                    user = currentUser!!,
                    onSurveySelected = {
                        selectedSurveyId = it
                    }
                )

            } else {

                SurveyDetailScreen(
                    surveyId = selectedSurveyId!!,
                    onBack = {
                        selectedSurveyId = null
                    }
                )
            }
        }
    }
}