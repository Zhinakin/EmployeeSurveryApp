package com.example.employeesurveryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.employeesurveryapp.data.repository.SurveyRepository

@Composable
fun AdminSurveyListScreen(
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Button(
            onClick = onBack
        ) {
            Text("Tilbage")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        SurveyRepository
            .getSurveys()
            .forEach { survey ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            survey.surveyName
                        )

                        Text(
                            "År: ${survey.surveyYearId}"
                        )
                    }
                }
            }
    }
}