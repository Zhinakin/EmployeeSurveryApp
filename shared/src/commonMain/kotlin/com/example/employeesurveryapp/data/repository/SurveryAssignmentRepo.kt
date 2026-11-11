package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.SurveyAssignment

class SurveyAssignmentRepository {

    fun getAssignments(): List<SurveyAssignment> {
        return listOf(
            SurveyAssignment(
                assignmentId = 1,
                surveyId = 1,
                userId = 2,
                assignedDate = "2026-11-11",
                completedDate = "2026-11-11"
            ),

            SurveyAssignment(
                assignmentId = 2,
                surveyId = 2,
                userId = 3,
                assignedDate = "2026-11-11",
                completedDate = null
            )
        )
    }

    fun getAssignmentsForUser(
        userId: Int
    ): List<SurveyAssignment> {

        return getAssignments().filter {
            it.userId == userId
        }
    }

    fun hasCompleted(
        userId: Int,
        surveyId: Int
    ): Boolean {

        return getAssignments().any {
            it.userId == userId &&
                    it.surveyId == surveyId &&
                    it.completedDate != null
        }
    }

    fun getCompletedAssignments(): List<SurveyAssignment> {

        return getAssignments().filter {
            it.completedDate != null
        }
    }
}