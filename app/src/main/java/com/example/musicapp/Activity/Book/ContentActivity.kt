package com.example.musicapp.Activity.Book

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.ProgressActivity
import com.example.musicapp.Activity.Quiz.QuizActivity
import com.example.musicapp.Activity.RatingActivity
import com.example.musicapp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.content_layout.nav_view

class ContentActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        nav_view.setNavigationItemSelectedListener (this)
        content_title.text = intent.getStringExtra("title")
        content_text.text = intent.getStringExtra("content")
        content_image.setImageResource(intent.getIntExtra("imageId", R.drawable.pageback))
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