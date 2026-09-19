package com.example.musicapp.Domain

import com.example.musicapp.R

object Constants {

    fun getQuestion(): ArrayList<QuestionListGame> {

        val questionList = ArrayList<QuestionListGame> ()

        val quest1 = QuestionListGame(
            1,
            "Какой интервал изображен на фото?",
            R.drawable.intervals1,
            "Минута",
            "Септима",
            "Терция",
            "Квинта",
            1
        )
        val quest2 = QuestionListGame(
            2,
            "Какой интервал изображен на фото?",
            R.drawable.intervals2,
            "Минута",
            "Септима",
            "Терция",
            "Квинта",
            4
        )
        val quest3 = QuestionListGame(
            3,
            "Какой интервал изображен на фото?",
            R.drawable.intervals3,
            "Минута",
            "Септима",
            "Терция",
            "Квинта",
            1
        )
        val quest4 = QuestionListGame(
            4,
            "Какой интервал изображен на фото?",
            R.drawable.intervals4,
            "Минута",
            "Септима",
            "Терция",
            "Квинта",
            3
        )
        questionList.add(quest1)
        questionList.add(quest2)
        questionList.add(quest3)
        questionList.add(quest4)

        return questionList
    }
}