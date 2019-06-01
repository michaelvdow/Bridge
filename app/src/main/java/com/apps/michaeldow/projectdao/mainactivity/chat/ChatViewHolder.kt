package com.apps.michaeldow.projectdao.mainactivity.chat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_chat.view.*

class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(chat: Chat) {
        itemView.name.text = chat.name
    }
}