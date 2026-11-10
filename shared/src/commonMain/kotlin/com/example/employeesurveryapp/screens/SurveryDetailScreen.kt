package com.example.employeesurveryapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.employeesurveryapp.data.repository.QuestionRepository

@Composable
fun SurveyDetailScreen(
    surveyId: Int,
    onBack: () -> Unit
) {

    val repository = QuestionRepository()

    val questions =
        repository.getQuestionsForSurvey(surveyId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text("Spørgeskema")

        LazyColumn {

            items(questions) { question ->

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {

                    Text(
                        text = question.questionText
                    )

                }
            }
        }

        Button(
            onClick = {
                // gem svar senere
            }
        ) {

            Text("Afslut spørgeskema")
        }
    }
}

@Preview
@Composable
fun SurveyDetailPreview() {

    SurveyDetailScreen(
        surveyId = 1,
        onBack = {}
    )
}