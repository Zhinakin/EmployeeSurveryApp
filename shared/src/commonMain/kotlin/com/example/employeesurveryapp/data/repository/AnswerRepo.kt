package com.example.employeesurveryapp.data.repository

import com.example.employeesurveryapp.data.model.Answer

class AnswerRepository {

    private val answers = mutableListOf<Answer>()

    fun getAnswers(): List<Answer> {
        return answers
    }

    fun saveAnswer(answer: Answer) {
        answers.add(answer)
    }
}