package com.example.musicapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Activity.Book.ContentActivity
import com.example.musicapp.Activity.Chat.ChatingActivity
import com.example.musicapp.Domain.ChatListItem
import com.example.musicapp.Domain.ListItem
import com.example.musicapp.Domain.UserListItem
import com.example.musicapp.R

class ChatOwnUsersAdapter (listArray: ArrayList<ChatListItem>, context: Context):
    RecyclerView.Adapter<ChatOwnUsersAdapter.ViewHolder>() {

    var listArr = listArray
    var cont = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.user_name)
        val image = view.findViewById<ImageView>(R.id.user_image)
        val message = view.findViewById<TextView>(R.id.user_message)
        val time = view.findViewById<TextView>(R.id.user_time)
        fun bind(listItem: ChatListItem, context: Context) {
            val textMessage = if(listItem.last_message.length > 30) {
                listItem.last_message.substring(0, 30) + "..."
            } else {
                listItem.last_message
            }
            message.text = textMessage
            name.text = listItem.user_name
            time.text = listItem.last_time
            image.setImageResource(listItem.image_id)
            itemView.setOnClickListener() {
                val intent = Intent(context, ChatingActivity::class.java).apply {
                    putExtra("name", name.text.toString())
                    putExtra("imageId", listItem.image_id)
                }
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(cont)
        return ViewHolder(inflater.inflate(R.layout.item_chat,parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArr[position]
        holder.bind(listItem, cont)
    }
    override fun getItemCount(): Int {
        return listArr.size
    }
    fun updateChatOwnUsersAdapter(listArray: List<ChatListItem>) {
        listArr.clear()
        listArr.addAll(listArray)
        notifyDataSetChanged()
    }
}