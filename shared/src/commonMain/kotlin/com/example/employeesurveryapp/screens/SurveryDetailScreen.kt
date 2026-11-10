package com.example.employeesurveryapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.OutlinedTextField
import com.example.employeesurveryapp.data.model.Answer
import com.example.employeesurveryapp.data.repository.AnswerRepository
import com.example.employeesurveryapp.data.model.QuestionType
import com.example.employeesurveryapp.data.repository.QuestionRepository

@Composable
fun SurveyDetailScreen(
    surveyId: Int,
    onBack: () -> Unit
) {

    val repository = QuestionRepository()

    val questions = repository.getQuestionsForSurvey(surveyId)
    val answerRepository = remember {
        AnswerRepository()
    }
    val answers = remember {
        mutableMapOf<Int, String>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Spørgeskema",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(questions) { question ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = question.questionText,
                            style = MaterialTheme.typography.titleMedium
                        )

                        when (question.questionType) {

                            QuestionType.RATING -> {

                                var selectedRating by remember {
                                    mutableStateOf(0)
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {

                                    (1..5).forEach { rating ->

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            RadioButton(
                                                selected = selectedRating == rating,
                                                onClick = {
                                                    selectedRating = rating
                                                    answers[question.questionId] =
                                                        rating.toString()
                                                }
                                            )

                                            Text(rating.toString())
                                        }
                                    }
                                }
                            }

                            QuestionType.YES_NO -> {

                                var answer by remember {
                                    mutableStateOf<Boolean?>(null)
                                }

                                Row {

                                    RadioButton(
                                        selected = answer == true,
                                        onClick = {
                                            answer = true
                                            answers[question.questionId] = "Ja"
                                        }
                                    )

                                    Text("Ja")

                                    Spacer(
                                        modifier = Modifier.padding(8.dp)
                                    )

                                    RadioButton(
                                        selected = answer == false,
                                        onClick = {
                                            answer = false
                                            answers[question.questionId] = "Nej"
                                        }
                                    )

                                    Text("Nej")
                                }
                            }

                            QuestionType.TEXT -> {

                                var answer by remember {
                                    mutableStateOf("")
                                }

                                OutlinedTextField(
                                    value = answer,
                                    onValueChange = {
                                        answer = it
                                        answers[question.questionId] = it
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    minLines = 3,
                                    label = {
                                        Text("Dit svar")
                                    }
                                )
                            }

                            QuestionType.MULTIPLE_CHOICE -> {
                                Text(
                                    text = "Multiple Choice spørgsmål",
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        Button(
            onClick = {

                answers.forEach { (questionId, value) ->

                    val answer = Answer(
                        answerId = 0,
                        assignmentId = 1,
                        questionId = questionId,
                        answerValue = value,
                        answerDate = "2026-11-10"
                    )

                    answerRepository.saveAnswer(answer)

                    println("Saved: $answer")
                }

                println("All answers:")
                answerRepository.getAnswers().forEach {
                    println(it)
                }

                onBack()
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
