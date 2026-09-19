package com.example.quizmobileapp

import android.os.Parcel
import android.os.Parcelable

data class QuestionList(
    val answerFirst: String?,
    val answerSecond: String?,
    val answerThird: String?,
    val answerFourth: String?,
    val question: String?,
    val answer: String?,
    var userSelectedAnswer: String?
)
