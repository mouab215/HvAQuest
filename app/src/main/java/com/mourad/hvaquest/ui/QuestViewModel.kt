package com.mourad.hvaquest.ui

import androidx.lifecycle.ViewModel
import com.mourad.hvaquest.model.Question
import com.mourad.hvaquest.repository.QuestRepository

class QuestViewModel: ViewModel() {

    private val repository = QuestRepository()
    var questionIndex: Int = 0

    fun isAnswerCorrect(answer: String): Boolean {
        return answer == getQuestion().correctAnswer
    }

    fun getQuestions(): List<Question> {
        return repository.getHvaQuest()
    }

    fun getQuestion(): Question {
        return getQuestions()[questionIndex]
    }
}