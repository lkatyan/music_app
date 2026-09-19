package com.example.musicapp.Activity.Quiz

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.musicapp.Activity.Book.BookActivity
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.ProgressActivity
import com.example.musicapp.Activity.RatingActivity
import com.example.musicapp.R
import com.example.quizmobileapp.QuestionList
import com.example.quizmobileapp.QuestionsBank
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.content_layout.nav_view

class TestActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var questionsCount: TextView
    lateinit var question: TextView

    lateinit var answerFirst: AppCompatButton
    lateinit var answerSecond: AppCompatButton
    lateinit var answerThird: AppCompatButton
    lateinit var answerFourth: AppCompatButton
    lateinit var nextQuestion: AppCompatButton

    lateinit var timerCount: TextView
    var quizTimer: CountDownTimer? = null

    lateinit var questionList: List<QuestionList>
    var currentQuestionPosition: Int = 0
    var selectedAnswerByUser: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        nav_view.setNavigationItemSelectedListener (this)
        textViewTitleQuiz.text = intent.getStringExtra("title")


        questionsCount = findViewById(R.id.textViewQuestionsCount)
        question = findViewById(R.id.textViewQuestion)

        answerFirst = findViewById(R.id.buttonAnswerFirst)
        answerSecond = findViewById(R.id.buttonAnswerSecond)
        answerThird = findViewById(R.id.buttonAnswerThird)
        answerFourth= findViewById(R.id.buttonAnswerFourth)
        nextQuestion = findViewById(R.id.buttonNextQuestion)


        val choose: String? = intent.getStringExtra("title")


        val qBank = QuestionsBank()
        questionList = QuestionsBank.getQuestions(qBank, choose)

        startTimer(10000)
        questionsCount.text = ""+(currentQuestionPosition+1)+"/"+questionList.size
        question.text = questionList.get(0).question
        answerFirst.text = questionList.get(0).answerFirst
        answerSecond.text = questionList.get(0).answerSecond
        answerThird.text = questionList.get(0).answerThird
        answerFourth.text = questionList.get(0).answerFourth

        answerFirst.setOnClickListener {
            if (selectedAnswerByUser.isEmpty()) {
                selectedAnswerByUser = answerFirst.text.toString()
                answerFirst.setBackgroundResource(R.drawable.round_background_incorrect)

                revealAnswer()
                questionList.get(currentQuestionPosition).userSelectedAnswer = selectedAnswerByUser
            }
        }
        answerSecond.setOnClickListener {
            if (selectedAnswerByUser.isEmpty()) {
                selectedAnswerByUser = answerSecond.text.toString()
                answerSecond.setBackgroundResource(R.drawable.round_background_incorrect)

                revealAnswer()
                questionList.get(currentQuestionPosition).userSelectedAnswer = selectedAnswerByUser
            }
        }
        answerThird.setOnClickListener {
            if (selectedAnswerByUser.isEmpty()) {
                selectedAnswerByUser = answerThird.text.toString()
                answerThird.setBackgroundResource(R.drawable.round_background_incorrect)

                revealAnswer()
                questionList.get(currentQuestionPosition).userSelectedAnswer = selectedAnswerByUser
            }
        }
        answerFourth.setOnClickListener {
            if (selectedAnswerByUser.isEmpty()) {
                selectedAnswerByUser = answerFourth.text.toString()
                answerFourth.setBackgroundResource(R.drawable.round_background_incorrect)

                revealAnswer()
                questionList.get(currentQuestionPosition).userSelectedAnswer = selectedAnswerByUser
            }
        }
        nextQuestion.setOnClickListener {
            if (selectedAnswerByUser.isEmpty()) {
                Toast.makeText(this, "Выберите вариант ответа", Toast.LENGTH_SHORT).show()
            } else {
                changeQuestion()
            }
        }
    }

    fun startTimer (timeMillis: Long) {
        quizTimer?.cancel()
        timerCount = findViewById(R.id.textViewTimerCount)
        quizTimer = object : CountDownTimer(timeMillis, 1) {
            override fun onTick(timeM: Long) {
                timerCount.text = (timeM/1000).toString()
            }
            override fun onFinish() {
                quizTimer?.cancel()
                timerCount.text = "finish"
                Toast.makeText(this@TestActivity, " Время вышло", LENGTH_SHORT).show()
                finish()
                val intent = Intent(this@TestActivity, ProgressActivity::class.java)
                //intent.putExtra("correct", getCorrectAnswer())
                //intent.putExtra("incorrect", getInCorrectAnswer())
                startActivity(intent)
            }
        }.start()
    }

    private fun getCorrectAnswer(): Int {
        var correctAnswers = 0
        for (i in questionList.indices) {
            var getUserSelectedAnswer: String? = questionList[i].userSelectedAnswer
            var getAnswer: String? = questionList[i].answer
            if (getUserSelectedAnswer == getAnswer) {
                correctAnswers++
            }
        }
        return correctAnswers
    }

    fun getInCorrectAnswer(): Int {
        var correctAnswers: Int = 0
        for (num in 0..questionList.size) {
            var getUserSelectedAnswer: String? = questionList.get(num).userSelectedAnswer
            var getAnswer: String? = questionList.get(num).answer
            if (!getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++
            }
        }
        return correctAnswers
    }

    fun onBack(view: View) {
        quizTimer?.cancel()
        finish()
    }

    override fun onBackPressed() {
        quizTimer?.cancel()
        finish()
    }

    fun revealAnswer() {
        var getAnswer: String? = questionList.get(currentQuestionPosition).answer

        if (answerFirst.text.toString() == getAnswer) {
            answerFirst.setBackgroundResource(R.drawable.round_background_correct)
        } else if (answerSecond.text.toString() == getAnswer) {
            answerSecond.setBackgroundResource(R.drawable.round_background_correct)
        } else if (answerThird.text.toString() == getAnswer) {
            answerThird.setBackgroundResource(R.drawable.round_background_correct)
        } else if (answerFourth.text.toString() == getAnswer) {
            answerFourth.setBackgroundResource(R.drawable.round_background_correct)
        }
    }

    private fun changeQuestion() {
        currentQuestionPosition+=1
        if ((currentQuestionPosition+1) == questionList.size) {
            nextQuestion.text = "Завершить тест"
        }
        if (currentQuestionPosition < questionList.size) {
            selectedAnswerByUser = ""
            answerFirst.setBackgroundResource(R.drawable.lavender_border)
            answerSecond.setBackgroundResource(R.drawable.lavender_border)
            answerThird.setBackgroundResource(R.drawable.lavender_border)
            answerFourth.setBackgroundResource(R.drawable.lavender_border)

            questionsCount.text = ""+(currentQuestionPosition+1)+"/"+questionList.size
            question.text = questionList.get(currentQuestionPosition).question
            answerFirst.text = questionList.get(currentQuestionPosition).answerFirst
            answerSecond.text = questionList.get(currentQuestionPosition).answerSecond
            answerThird.text = questionList.get(currentQuestionPosition).answerThird
            answerFourth.text = questionList.get(currentQuestionPosition).answerFourth
            currentQuestionPosition-1
            startTimer(10000)
        } else {
            quizTimer?.cancel()
            finish()
            val intent = Intent(this@TestActivity, ProgressActivity::class.java)
            var correctAnswers: Int = getCorrectAnswer()
            intent.putExtra("correctAnswers", correctAnswers)
            //intent.putExtra("incorrect", getInCorrectAnswer())
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_infos -> {
                val intent = Intent(applicationContext, BookActivity::class.java)
                startActivity(intent)
            }
            R.id.item_tests -> {
                val intent = Intent(applicationContext, QuizActivity::class.java)
                startActivity(intent)
            }
            R.id.item_chat -> {
                val intent = Intent(applicationContext, ChatActivity::class.java)
                startActivity(intent)
            }
            R.id.item_rating -> {
                val intent = Intent(applicationContext, RatingActivity::class.java)
                startActivity(intent)
            }
            R.id.item_progress -> {
                val intent = Intent(applicationContext, ProgressActivity::class.java)
                startActivity(intent)
            }
        }
        this.finish()
        return true
    }
}