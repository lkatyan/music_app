package com.example.musicapp.Activity.Quiz

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.Activity.Book.BookActivity
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.ProgressActivity
import com.example.musicapp.Activity.RatingActivity
import com.example.musicapp.Domain.Constants
import com.example.musicapp.Domain.QuestionListGame
import com.example.musicapp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_test.textViewTitleQuiz
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.content_layout.nav_view

class GameActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mQuestionList: ArrayList<QuestionListGame>

    private var mSelectedPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mCurrentPosition: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        nav_view.setNavigationItemSelectedListener (this)
        textViewTitleQuiz.text = intent.getStringExtra("title")

        mQuestionList = Constants.getQuestion()

        tv_optionOne.setOnClickListener {
            selectedOptionView(tv_optionOne, 1)
        }
        tv_optionTwo.setOnClickListener {
            selectedOptionView(tv_optionTwo, 2)
        }
        tv_optionThree.setOnClickListener {
            selectedOptionView(tv_optionThree, 3)
        }
        tv_optionFour.setOnClickListener {
            selectedOptionView(tv_optionFour, 4)
        }
        btnSubmit.setOnClickListener {
            if (mSelectedPosition == 0){
                mCurrentPosition++
                when {
                    mCurrentPosition <= mQuestionList.size -> {
                        setQuestion()
                    } else -> {
                        finish()
                        //val intent = Intent(this@GameActivity, ResultActivity::class.java)
                        val intent = Intent(this@GameActivity, ProgressActivity::class.java)
                        startActivity(intent)
                        this.finish()
                    }
                }
            } else {
                val question = mQuestionList[mCurrentPosition-1]
                if (question.correctAnswer != mSelectedPosition) {
                    answerView(mSelectedPosition, R.drawable.round_background_incorrect)
                } else {
                    mCorrectAnswer++
                }
                question.correctAnswer?.let { it1 -> answerView(it1, R.drawable.round_background_correct) }
                if (mCurrentPosition == mQuestionList.size) {
                    btnSubmit.text = "Завершить тест"
                } else {
                    btnSubmit.text = "Следующий вопрос"
                }
                mSelectedPosition = 0
            }
        }
        setQuestion()
    }

    private fun selectedOptionView(tv: TextView, selectedPosition: Int) {
        defaultAppearance()
        mSelectedPosition = selectedPosition

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = getDrawable(R.drawable.lavender_border_focus)
    }

    private fun answerView(mSelectedPosition: Int, drawableView: Int) {
        when (mSelectedPosition) {
            1 -> tv_optionOne.setBackgroundResource(drawableView)
            2 -> tv_optionTwo.setBackgroundResource(drawableView)
            3 -> tv_optionThree.setBackgroundResource(drawableView)
            4 -> tv_optionFour.setBackgroundResource(drawableView)
        }
    }

    private fun setQuestion() {

        var question: QuestionListGame = mQuestionList[mCurrentPosition-1]
        tv_question.text = question.question
        imageView.setImageResource(question.image)
        tv_optionOne.text = question.answerFirst
        tv_optionTwo.text = question.answerSecond
        tv_optionThree.text = question.answerThird
        tv_optionFour.text = question.answerFourth

        pb.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + pb.max

        defaultAppearance()

        if (mCurrentPosition == mQuestionList.size) {
            btnSubmit.text = "Завершить тест"
        } else {
            btnSubmit.text = "Ответить"
        }
    }

    private fun defaultAppearance() {
        val options = ArrayList<TextView>()
        options.add(0, tv_optionOne)
        options.add(1, tv_optionTwo)
        options.add(2, tv_optionThree)
        options.add(3, tv_optionFour)

        for (option in options){
            option.typeface = Typeface.DEFAULT
            option.setBackgroundResource(R.drawable.lavender_border)
        }
    }

    fun onBack(view: View) {
        finish()
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