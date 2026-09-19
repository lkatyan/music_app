package com.example.musicapp.Domain

data class QuestionListGame(
    val id: Int,
    val question: String?,
    val image: Int,
    val answerFirst: String?,
    val answerSecond: String?,
    val answerThird: String?,
    val answerFourth: String?,

    val correctAnswer: Int?
)