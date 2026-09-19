package com.example.musicapp.Activity.Book

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.*
import com.example.musicapp.Activity.Chat.ChatActivity
import com.example.musicapp.Activity.ProgressActivity
import com.example.musicapp.Activity.Quiz.QuizActivity
import com.example.musicapp.Activity.RatingActivity
import com.example.musicapp.Adapter.BookAdapter
import com.example.musicapp.Domain.ListItem
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_content.*

class BookViewActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: BookAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_view)
        nav_view.setNavigationItemSelectedListener (this)
        val book_search = findViewById<AutoCompleteTextView>(R.id.book_search)
        book_search.threshold = 5
        var card_number = 1

        var list = ArrayList<ListItem>()

        recycler_view.hasFixedSize()
        recycler_view.layoutManager = LinearLayoutManager(this)

        list.addAll(fillArray("", resources.getStringArray(R.array.one),
            resources.getStringArray(R.array.two),
            getImageId(R.array.three)))

        adapter = BookAdapter(list, this)
        recycler_view.adapter = adapter

        val arguments = intent.extras
        if (arguments != null) {
            card_number = arguments.getInt("number")
        }

        fun updating(key: Int, search_query: String) {
            when (key) {
                1 -> {
                    adapter?.updateBookAdapter(fillArray(search_query, resources.getStringArray(R.array.one),
                        resources.getStringArray(R.array.two),
                        getImageId(R.array.three)))
                    val search_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(
                        R.array.one
                    ))
                    book_search.setAdapter(search_adapter)
                }
                2 -> {
                    adapter?.updateBookAdapter(fillArray(search_query, resources.getStringArray(R.array.one_two),
                        resources.getStringArray(R.array.two_two),
                        getImageId(R.array.three_two)))
                    val search_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(
                        R.array.one_two
                    ))
                    book_search.setAdapter(search_adapter)
                }
                3 -> {
                    adapter?.updateBookAdapter(fillArray(search_query, resources.getStringArray(R.array.one_three),
                        resources.getStringArray(R.array.two_three),
                        getImageId(R.array.three_three)))
                    val search_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(
                        R.array.one_three
                    ))
                    book_search.setAdapter(search_adapter)
                }
                4 -> {
                    adapter?.updateBookAdapter(fillArray(search_query, resources.getStringArray(R.array.one_four),
                        resources.getStringArray(R.array.two_four),
                        getImageId(R.array.three_four)))
                    val search_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(
                        R.array.one_four
                    ))
                    book_search.setAdapter(search_adapter)
                }
                5 -> {
                    adapter?.updateBookAdapter(fillArray(search_query, resources.getStringArray(R.array.one_five),
                        resources.getStringArray(R.array.two_five),
                        getImageId(R.array.three_five)))
                    val search_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(
                        R.array.one_five
                    ))
                    book_search.setAdapter(search_adapter)
                }
                6 -> {
                    adapter?.updateBookAdapter(fillArray(search_query, resources.getStringArray(R.array.one_six),
                        resources.getStringArray(R.array.two_six),
                        getImageId(R.array.three_six)))
                    val search_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(
                        R.array.one_six
                    ))
                    book_search.setAdapter(search_adapter)
                }
            }
        }
        updating(card_number, "")

        book_search.onItemClickListener = AdapterView.OnItemClickListener { parent, _,
                                                                            position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            updating(card_number, selectedItem)
        }

        book_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updating(card_number, s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

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