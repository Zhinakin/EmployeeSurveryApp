package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.Survey

class SurveyRepository {

    fun getSurveys(): List<Survey> {
        return listOf(
            Survey(
                surveyId = 1,
                surveyYearId = 1,
                surveyName = "Trivselsmåling 2027",
                startDate = null,
                endDate = null,
                isActive = true
            ),
            Survey(
                surveyId = 2,
                surveyYearId = 1,
                surveyName = "Ledelsesevaluering 2027",
                startDate = null,
                endDate = null,
                isActive = true
            )
        )
    }
}