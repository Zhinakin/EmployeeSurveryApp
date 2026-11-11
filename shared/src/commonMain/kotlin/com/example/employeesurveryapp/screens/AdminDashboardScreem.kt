package com.example.employeesurveryapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.employeesurveryapp.data.model.Survey
import com.example.employeesurveryapp.data.repository.SurveyAssignmentRepository
import com.example.employeesurveryapp.data.repository.SurveyRepository
import com.example.employeesurveryapp.data.repository.UserRepository

@Composable
fun AdminDashboardScreen(    onLogout: () -> Unit) {
        val surveyRepository = SurveyRepository
        val userRepository = UserRepository()
        val assignmentRepository = SurveyAssignmentRepository()

        val surveys = surveyRepository.getSurveys()
        val users = userRepository.getUsers()
        val assignments = assignmentRepository.getAssignments()

        var showCreateSurvey by remember {
            mutableStateOf(false)
        }
        var showSurveyList by remember {
            mutableStateOf(false)
        }
    if (showSurveyList) {

        AdminSurveyListScreen(
            onBack = {
                showSurveyList = false
            }
        )

        return
    }

    if (showCreateSurvey) {

        CreateSurveyScreen(
            onCreateSurvey = { name, year ->

                surveyRepository.addSurvey(
                    Survey(
                        surveyId = surveyRepository.getSurveys().size + 1,
                        surveyYearId = year,
                        surveyName = name,
                        startDate = null,
                        endDate = null,
                        isActive = true
                    )
                )

                showCreateSurvey = false
            }
        )

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E293B),
                        Color(0xFFF8FAFC)
                    )
                )
            )
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF2563EB)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Admin Dashboard",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )

                Text(
                    text = "Oversigt over systemet",
                    color = Color.White
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Button(
                    onClick = onLogout
                ) {
                    Text("Log ud")
                }
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Button(
                    onClick = {
                        showCreateSurvey = true
                    }
                ) {
                    Text("➕ Opret spørgeskema")
                }
                Button(
                    onClick = {
                        showSurveyList = true
                    }
                ) {
                    Text("📋 Se alle spørgeskemaer")
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "Antal brugere: ${users.size}"
                )
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "Antal Spørgeskemaer: ${surveys.size}"
                )
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "Antal tildelinger:${assignments.size}"
                )
            }
        }


        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Survey Status"
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                users
                    .filter { it.roleId != 1 }
                    .forEach { user ->

                        val userAssignments =
                            assignmentRepository.getAssignmentsForUser(
                                user.userId
                            )

                        val completed =
                            userAssignments.all {
                                it.completedDate != null
                            }

                        Text(
                            text =
                                "${user.firstName} ${user.lastName} " +
                                        if (completed) "✅"
                                        else "⏳"
                        )
                    }
            }
        }
    }
}
