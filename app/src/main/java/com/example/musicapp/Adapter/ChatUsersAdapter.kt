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
import com.example.musicapp.Domain.ListItem
import com.example.musicapp.Domain.UserListItem
import com.example.musicapp.R

class ChatUsersAdapter (listArray: ArrayList<UserListItem>, context: Context):
    RecyclerView.Adapter<ChatUsersAdapter.ViewHolder>() {

    var listArr = listArray
    var cont = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.user_name)
        val image = view.findViewById<ImageView>(R.id.user_image)
        fun bind(listItem: UserListItem, context: Context) {
            val textName = if(listItem.user_name.length > 7) {
                listItem.user_name.substring(0, 7) + ".."
            } else {
                listItem.user_name
            }
            name.text = textName
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
        return ViewHolder(inflater.inflate(R.layout.item_user,parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArr[position]
        holder.bind(listItem, cont)
    }
    override fun getItemCount(): Int {
        return listArr.size
    }
    fun updateChatUsersAdapter(listArray: List<UserListItem>) {
        listArr.clear()
        listArr.addAll(listArray)
        notifyDataSetChanged()
    }
}