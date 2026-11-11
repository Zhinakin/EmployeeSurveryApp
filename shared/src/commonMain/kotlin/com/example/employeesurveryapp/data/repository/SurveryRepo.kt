package com.example.employeesurveryapp.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.example.employeesurveryapp.data.model.Survey

object SurveyRepository {

    private val surveys = mutableStateListOf(

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

    fun getSurveys(): List<Survey> {
        return surveys
    }

    fun addSurvey(survey: Survey) {
        surveys.add(survey)
    }
}