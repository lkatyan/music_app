package com.example.musicapp.Activity.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.musicapp.Activity.*
import com.example.musicapp.Activity.Appl.ApplActivity
import com.example.musicapp.Activity.Book.BookActivity
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.Quiz.QuizActivity
import com.example.musicapp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener (this)
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
            R.id.item_appl -> {
                val intent = Intent(applicationContext, ApplActivity::class.java)
                startActivity(intent)
            }
        }
        this.finish()
        return true
    }
}