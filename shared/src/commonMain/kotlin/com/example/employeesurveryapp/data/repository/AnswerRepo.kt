package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.Answer

class AnswerRepository {

    private val answers = mutableListOf<Answer>()

    fun saveAnswer(answer: Answer) {

        answers.removeAll {
            it.questionId == answer.questionId
        }

        answers.add(answer)
    }

    fun getAnswers(): List<Answer> {
        return answers
    }
}