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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.employeesurveryapp.data.repository.SurveyAssignmentRepository
import com.example.employeesurveryapp.data.repository.SurveyRepository
import com.example.employeesurveryapp.data.repository.UserRepository


val userRepository = UserRepository()
val users = userRepository.getUsers()
val surveyRepository = SurveyRepository()
val surveys = surveyRepository.getSurveys()
val assignmentRepository = SurveyAssignmentRepository()
val assignments = assignmentRepository.getAssignments()

@Composable
fun AdminDashboardScreen() {

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