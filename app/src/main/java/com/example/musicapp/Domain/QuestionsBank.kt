package com.example.quizmobileapp

class QuestionsBank {

    companion object {
        fun getQuestions(questionsBank: QuestionsBank, selectedQuizName: String?): List<QuestionList> {
            return when (selectedQuizName) {
                "stars" -> questionsBank.starsQuestions()
                "animals" -> questionsBank.animalsQuestions()
                "music" -> questionsBank.musicQuestions()
                "Музыкальные термины" -> questionsBank.plantsQuestions()
                else -> questionsBank.plantsQuestions()
            }
        }
    }

    private fun starsQuestions(): List<QuestionList> {
        var questionList: MutableList<QuestionList> = arrayListOf()
        var questionFirst = QuestionList(
            "Уран",
            " Юпитер",
            "Церера",
            "Сатурн",
            "R.drawable.intervals",
            "Юпитер",
            "")
        var questionSecond = QuestionList(
            "Пять",
            "Девять",
            "Семь",
            "Восемь",
            "hjk",
            "Восемь",
            "")
        var questionThird = QuestionList(
            "Два спутника",
            "Пять спутников",
            "У Марса нет спутников",
            "Четыре спутника",
            "@drawable/intervals",
            "Два спутника",
            "")
        var questionFourth = QuestionList(
            "Ио",
            "Фобос",
            "Европа",
            "Ганимед",
            "ghj",
            "Ганимед",
            "")
        questionList.add(questionFirst)
        questionList.add(questionSecond)
        questionList.add(questionThird)
        questionList.add(questionFourth)
        return questionList
    }

    private fun animalsQuestions(): List<QuestionList> {
        var questionList: MutableList<QuestionList> = arrayListOf()
        var questionFirst = QuestionList(
            "Верблюд",
            "Панда",
            "Коала",
            "Слон",
            "Какое животное обитает только в Китае?",
            "Панда",
            "")
        var questionSecond = QuestionList(
            "Альбатрос",
            "Журавль",
            "Коршун",
            "Орлан",
            "У какой птицы самый большой размах крыльев? ",
            "Альбатрос",
            "")
        var questionThird = QuestionList(
            "Лени",
            "Мудрости",
            "Доброты",
            "Терпения",
            "Символом чего считается сова?",
            "Мудрости",
            "")
        var questionFourth = QuestionList(
            "Лени",
            "Мудрости",
            "Доброты",
            "Терпения",
            "Символом чего считается программист?",
            "Лени",
            "")
        questionList.add(questionFirst)
        questionList.add(questionSecond)
        questionList.add(questionThird)
        questionList.add(questionFourth)
        return questionList
    }

    private fun musicQuestions(): List<QuestionList> {
        var questionList: MutableList<QuestionList> = arrayListOf()
        var questionFirst = QuestionList(
            "15",
            "22",
            "40",
            "30",
            "Сколько тональностей в музыке?",
            "30",
            "")
        var questionSecond = QuestionList(
            "Фа-Си-Ре-Соль",
            "Никак",
            "До-До-До-Ми",
            "Ми-До-До-До",
            "Как разрешается доминантсептаккорд?",
            "Ми-До-До-До",
            "")
        var questionThird = QuestionList(
            "Ля мажор",
            "До мажор",
            "Ми мажор",
            "Ре мажор",
            "Какая диезная тональность является третьей по счету в квинтовом круге?",
            "Ля мажор",
            "")
        var questionFourth = QuestionList(
            "Септима",
            "Секунда",
            "Квинта",
            "Терция",
            "Музыкальный интервал шириной в три ступени?",
            "Терция",
            "")
        questionList.add(questionFirst)
        questionList.add(questionSecond)
        questionList.add(questionThird)
        questionList.add(questionFourth)
        return questionList
    }

    private fun plantsQuestions(): List<QuestionList> {
        var questionList: MutableList<QuestionList> = arrayListOf()
        var questionFirst = QuestionList(
            "Staccato",
            "Sforzando",
            "Legato",
            "Allegro",
            "Скорый темп, дословный перевод — «весело»",
            "Allegro",
            "")
        var questionSecond = QuestionList(
            "Staccato",
            "Pizzicato",
            "Sforzando",
            "Allegro",
            "Приём игры на струнных инструментах, когда звук извлекается щипками струн. Противоположная пометка — arco",
            "Pizzicato",
            "")
        var questionThird = QuestionList(
            "Pizzicato",
            "Legato",
            "Allegro",
            "Sforzando",
            "Внезапный акцент на ноте или звуке",
            "Sforzando",
            "")
        var questionFourth = QuestionList(
            "Sforzando",
            "Allegro",
            "Pizzicato",
            "Legato",
            "Связная игра, плавно, медленно",
            "Legato",
            "")
        questionList.add(questionFirst)
        questionList.add(questionSecond)
        questionList.add(questionThird)
        questionList.add(questionFourth)
        return questionList
    }
}