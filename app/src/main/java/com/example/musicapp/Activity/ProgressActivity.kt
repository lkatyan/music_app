package com.example.musicapp.Activity

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.Activity.Book.BookActivity
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.Quiz.QuizActivity
import com.example.musicapp.Adapter.ProgressAdapter
import com.example.musicapp.Domain.ListItem
import com.example.musicapp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.activity_progress.*
import kotlinx.android.synthetic.main.book_content.recycler_view

class ProgressActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: ProgressAdapter? = null
    var adapter_two: ProgressAdapter? = null
    var adapter_three: ProgressAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        nav_view.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()
        recycler_view.hasFixedSize()
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = ProgressAdapter(list, this)
        recycler_view.adapter = adapter
        adapter?.updateProgressAdapter(fillArray("", resources.getStringArray(R.array.prog_one),
            resources.getStringArray(R.array.prog_two),
            getImageId(R.array.prog_three)))

        var list_two = ArrayList<ListItem>()
        recycler_view_two.hasFixedSize()
        recycler_view_two.layoutManager = LinearLayoutManager(this)
        adapter_two = ProgressAdapter(list_two, this)
        recycler_view_two.adapter = adapter_two
        adapter_two?.updateProgressAdapter(fillArray("", resources.getStringArray(R.array.progb_one),
            resources.getStringArray(R.array.progb_two),
            getImageId(R.array.progb_three)))

        var list_three = ArrayList<ListItem>()
        recycler_view_three.hasFixedSize()
        recycler_view_three.layoutManager = LinearLayoutManager(this)
        adapter_three = ProgressAdapter(list_three, this)
        recycler_view_three.adapter = adapter_three
        adapter_three?.updateProgressAdapter(fillArray("", resources.getStringArray(R.array.progr_one),
            resources.getStringArray(R.array.progr_two),
            getImageId(R.array.progr_three)))
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
    fun fillArray(search_query: String, titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices) {
            if (search_query.isEmpty()) {
                var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
                listItemArray.add(listItem)
            } else {
                if (titleArray[n].contains(search_query, ignoreCase = true)) {
                    var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
                    listItemArray.add(listItem)
                }
            }
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