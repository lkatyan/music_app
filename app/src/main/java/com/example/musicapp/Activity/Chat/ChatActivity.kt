package com.example.musicapp.Activity.Chat

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.*
import com.example.musicapp.Activity.Book.BookActivity
import com.example.musicapp.Activity.ProgressActivity
import com.example.musicapp.Activity.Quiz.QuizActivity
import com.example.musicapp.Activity.RatingActivity
import com.example.musicapp.Adapter.ChatOwnUsersAdapter
import com.example.musicapp.Adapter.ChatUsersAdapter
import com.example.musicapp.Domain.ChatListItem
import com.example.musicapp.Domain.UserListItem
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_main.nav_view

class ChatActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: ChatUsersAdapter? = null
    var adapter2: ChatUsersAdapter? = null
    var adapter3: ChatOwnUsersAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        nav_view.setNavigationItemSelectedListener (this)

//        users prepods
        var list = ArrayList<UserListItem>()
        rvUsersOne.hasFixedSize()
        rvUsersOne.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        list.addAll(fillArray(resources.getStringArray(R.array.users_onep),
            getImageId(R.array.users_twop)))
        adapter = ChatUsersAdapter(list, this)
        rvUsersOne.adapter = adapter

        fun updating() {
            adapter?.updateChatUsersAdapter(
                fillArray(
                    resources.getStringArray(R.array.users_onep),
                    getImageId(R.array.users_twop)
                )
            )
        }
        updating()
//        users ucheniks
        var list2 = ArrayList<UserListItem>()
        rvUsersSec.hasFixedSize()
        rvUsersSec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        list2.addAll(fillArray(resources.getStringArray(R.array.users_one),
            getImageId(R.array.users_two)))
        adapter2 = ChatUsersAdapter(list2, this)
        rvUsersSec.adapter = adapter2

//      users chats
        var list3 = ArrayList<ChatListItem>()
        rvRecentChats.hasFixedSize()
        rvRecentChats.layoutManager = LinearLayoutManager(this)
        list3.addAll(fillChatArray(resources.getStringArray(R.array.user_chat_one),
            getImageId(R.array.user_chat_two),
            resources.getStringArray(R.array.user_chat_three),
            resources.getStringArray(R.array.user_chat_four)))
        adapter3 = ChatOwnUsersAdapter(list3, this)
        rvRecentChats.adapter = adapter3

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
    fun fillArray(nameArray: Array<String>, imageArray: IntArray): List<UserListItem> {
        var listItemArray = ArrayList<UserListItem>()
        for (n in nameArray.indices) {
            var listItem = UserListItem(imageArray[n], nameArray[n])
            listItemArray.add(listItem)

        }
        return listItemArray
    }
    fun fillChatArray(nameArray: Array<String>, imageArray: IntArray, lastMessageArray: Array<String>, lastTimeArray: Array<String>): List<ChatListItem> {
        var listItemArray = ArrayList<ChatListItem>()
        for (n in nameArray.indices) {
            var listItem = ChatListItem(imageArray[n], nameArray[n], lastMessageArray[n], lastTimeArray[n])
            listItemArray.add(listItem)

        }
        return listItemArray
    }
    fun getImageId(imageArrayId: Int): IntArray {
        var typeArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = typeArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = typeArray.getResourceId(i, 0)
        }
        typeArray.recycle()
        return ids
    }
}