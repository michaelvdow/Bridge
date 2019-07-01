package com.apps.michaeldow.projectdao.mainactivity.chat.messagescreen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_message_incoming_text.view.*

class MessageIncomingTextViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(message: Message) {
        itemView.message.text = message.message

//        val reference = FirebaseStorage.getInstance().reference.child("profilePictures/" + message.id + "_picture.jpg")
//        GlideApp.with(itemView).load(reference).apply(RequestOptions.circleCropTransform()).into(itemView)
    }
}