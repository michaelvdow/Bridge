package com.apps.michaeldow.projectdao.mainactivity.chat

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.apps.michaeldow.projectdao.utils.GlideApp
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.list_item_chat.view.*
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import com.apps.michaeldow.projectdao.generated.callback.OnClickListener


class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(chat: Chat) {
        itemView.name.text = chat.name

        val reference = FirebaseStorage.getInstance().reference.child("profilePictures/" + chat.id + "_picture.jpg")
        GlideApp.with(itemView).load(reference).apply(RequestOptions.circleCropTransform()).into(itemView.image)
    }
}