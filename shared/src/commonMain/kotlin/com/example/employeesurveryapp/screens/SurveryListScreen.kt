package com.example.employeesurveryapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.employeesurveryapp.data.model.User
import com.example.employeesurveryapp.data.repository.SurveyRepository
import com.example.employeesurveryapp.data.repository.SurveyAssignmentRepository

@Composable
fun SurveyListScreen(
    user: User,
    onSurveySelected: (Int) -> Unit
) {

    val repository = SurveyRepository

    val assignmentRepository = SurveyAssignmentRepository()

    val allSurveys = repository.getSurveys()

    val assignments = assignmentRepository.getAssignmentsForUser(user.userId)

    val surveys =

        if (user.roleId == 1) {

            allSurveys

        } else {

            allSurveys.filter { survey ->

                assignments.any {
                    it.surveyId == survey.surveyId
                }

            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E293B),
                        Color(0xFFF8FAFC)
                    )
                )
            )
            .statusBarsPadding()
            .padding(16.dp)
    )
    {

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
                    text = "Velkommen ${user.firstName}",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )

                Text(
                    text = if (user.roleId == 1)
                        "Administrator"
                    else
                        "Medarbejder",
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.95f)
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Dine tildelte spørgeskemaer",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "Vælg et spørgeskema for at starte besvarelsen",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(surveys) { survey ->
                    val completed = assignmentRepository.hasCompleted(
                        user.userId,
                        survey.surveyId
                    )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onSurveySelected(
                                survey.surveyId
                            )
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        Text(
                            text = survey.surveyName,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = if (completed)
                                "✅ Besvaret"
                            else
                                "⏳ Afventer besvarelse",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (completed)
                                Color(0xFF16A34A)
                            else
                                Color(0xFFD97706)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SurveyListPreview() {

    SurveyListScreen(
        user = User(
            userId = 2,
            email = "test@test.dk",
            firstName = "Malthe",
            lastName = "Bruhn",
            passwordHash = "password123",
            isActive = true,
            roleId = 2
        ),
        onSurveySelected = {}
    )
}