package com.example.musicapp.Activity.Book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.cardview.widget.CardView
import com.example.musicapp.Activity.*
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.Quiz.QuizActivity
import com.example.musicapp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class BookActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        nav_view.setNavigationItemSelectedListener (this)

        var card_one = findViewById<CardView>(R.id.card_one)
        card_one.setOnClickListener {
            val intent = Intent(applicationContext, BookViewActivity::class.java)
            intent.putExtra("number", 1)
            startActivity(intent)
        }
        var card_two = findViewById<CardView>(R.id.card_two)
        card_two.setOnClickListener {
            val intent = Intent(applicationContext, BookViewActivity::class.java)
            intent.putExtra("number", 2)
            startActivity(intent)
        }
        var card_three = findViewById<CardView>(R.id.card_three)
        card_three.setOnClickListener {
            val intent = Intent(applicationContext, BookViewActivity::class.java)
            intent.putExtra("number", 3)
            startActivity(intent)
        }
        var card_four = findViewById<CardView>(R.id.card_four)
        card_four.setOnClickListener {
            val intent = Intent(applicationContext, BookViewActivity::class.java)
            intent.putExtra("number", 4)
            startActivity(intent)
        }
        var card_five = findViewById<CardView>(R.id.card_five)
        card_five.setOnClickListener {
            val intent = Intent(applicationContext, BookViewActivity::class.java)
            intent.putExtra("number", 5)
            startActivity(intent)
        }
        var card_six = findViewById<CardView>(R.id.card_six)
        card_six.setOnClickListener {
            val intent = Intent(applicationContext, BookViewActivity::class.java)
            intent.putExtra("number", 6)
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