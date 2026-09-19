package com.example.musicapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Domain.ListItem
import com.example.musicapp.R

class ProgressAdapter (listArray: ArrayList<ListItem>, context: Context):
    RecyclerView.Adapter<ProgressAdapter.ViewHolder>() {

    var listArr = listArray
    var cont = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.info_title)
        val info = view.findViewById<TextView>(R.id.info_text)
        fun bind(listItem: ListItem, context: Context) {
            title.text = listItem.title_text
            val textContent = if(listItem.info_text.length > 50) {
                listItem.info_text.substring(0, 50) + "..."
            } else {
                listItem.info_text
            }
            info.text = textContent
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(cont)
        return ViewHolder(inflater.inflate(R.layout.item_progress,parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArr[position]
        holder.bind(listItem, cont)
    }
    override fun getItemCount(): Int {
        return listArr.size
    }
    fun updateProgressAdapter(listArray: List<ListItem>) {
        listArr.clear()
        listArr.addAll(listArray)
        notifyDataSetChanged()
    }
}