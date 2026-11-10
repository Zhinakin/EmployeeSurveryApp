package com.example.employeesurveryapp.screens

import androidx.compose.foundation.clickable
import com.example.employeesurveryapp.data.repository.SurveyRepository
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SurveyListScreen(
    onSurveySelected: (Int) -> Unit
) {

    val repository = SurveyRepository()

    val surveys = repository.getSurveys()

    LazyColumn {

        items(surveys) { survey ->

            Button(
                onClick = {
                    onSurveySelected(survey.surveyId)
                }
            ) {
                Text(
                    text = survey.surveyName,
                    modifier = Modifier.clickable {
                        onSurveySelected(survey.surveyId)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun SurveyListPreview() {

    SurveyListScreen(
        onSurveySelected = {}
    )
}