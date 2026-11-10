package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.Question

class QuestionRepository {

    fun getQuestionsForSurvey(
        surveyId: Int
    ): List<Question> {

        return listOf(
            Question(
                questionId = 1,
                surveyId = surveyId,
                questionTypeId = 1,
                questionText = "Hvordan vurderer du arbejdsmiljøet?",
                displayOrder = 1,
                isRequired = true
            ),
            Question(
                questionId = 2,
                surveyId = surveyId,
                questionTypeId = 1,
                questionText = "Hvordan vurderer du ledelsen?",
                displayOrder = 2,
                isRequired = true
            ),
            Question(
                questionId = 3,
                surveyId = surveyId,
                questionTypeId = 3,
                questionText = "Har du forslag til forbedringer?",
                displayOrder = 3,
                isRequired = false
            )
        )
    }
}