package com.example.employeesurveryapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateSurveyScreen(
    onCreateSurvey: (String, Int) -> Unit
) {

    var surveyName by remember {
        mutableStateOf("")
    }

    var surveyYear by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text("Opret spørgeskema")

        OutlinedTextField(
            value = surveyName,
            onValueChange = {
                surveyName = it
            },
            label = {
                Text("Navn")
            }
        )

        OutlinedTextField(
            value = surveyYear,
            onValueChange = {
                surveyYear = it
            },
            label = {
                Text("År")
            }
        )

        Button(
            onClick = {

                val year = surveyYear.toIntOrNull()

                if (year != null) {
                    onCreateSurvey(
                        surveyName,
                        year
                    )
                }
            }
        ) {
            Text("Opret")
        }
    }
}