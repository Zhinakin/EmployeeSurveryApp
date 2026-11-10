package com.example.employeesurveryapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.employeesurveryapp.data.repository.SurveyRepository

@Composable
fun SurveyListScreen() {

    val repository = SurveyRepository()

    val surveys = repository.getSurveys()

    LazyColumn {

        items(surveys) { survey ->

            Text(
                text = survey.surveyName
            )
        }
    }
}