package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.Question
import com.example.employeesurveryapp.data.model.QuestionType

class QuestionRepository {

    fun getQuestionsForSurvey(
        surveyId: Int
    ): List<Question> {

        return listOf(
            Question(
                questionId = 1,
                surveyId = surveyId,
                questionType = QuestionType.RATING,
                questionText = "Hvordan vurderer du arbejdsmiljøet?",
                displayOrder = 1,
                isRequired = true
            ),
            Question(
                questionId = 2,
                surveyId = surveyId,
                questionType = QuestionType.RATING,
                questionText = "Hvordan vurderer du ledelsen?",
                displayOrder = 2,
                isRequired = true
            ),
            Question(
                questionId = 3,
                surveyId = surveyId,
                questionType = QuestionType.TEXT,
                questionText = "Har du forslag til forbedringer?",
                displayOrder = 3,
                isRequired = false
            )
        )
    }
}