package com.example.sample_masagge_client.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_masagge_client.R
import com.example.sample_masagge_client.data.Message
import kotlinx.android.synthetic.main.item_message.view.*
import kotlinx.android.synthetic.main.item_message_my.view.*
import java.text.SimpleDateFormat
import java.util.*

class MessagesAdapter(
    private val muUsername: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val messages = mutableListOf<Message>()
        private val MESSAGE_TYPE = 0
        private val MY_MESSAGE_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MY_MESSAGE_TYPE) {
            val vMyMessage =
                LayoutInflater.from(parent.context).inflate(R.layout.item_message_my, parent, false)
            MyMessageViewHolder(vMyMessage)
        } else {
            val vMessage =
                LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
            MessageViewHolder(vMessage)

        }
    }

    override fun getItemCount() = messages.size

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].author == muUsername) {
            MY_MESSAGE_TYPE
        } else {
            MESSAGE_TYPE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == MY_MESSAGE_TYPE) {
            (holder as MyMessageViewHolder).bind(messages[position])
        } else {
            (holder as MyMessageViewHolder).bind(messages[position])
        }
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: Message) = itemView.apply {
            senderName.text = message.author
            messageText.text = message.text
            sendData.text =
                SimpleDateFormat("HH:mm MMM dd", Locale.getDefault()).format(message.date)
        }

    }

    class MyMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: Message) = itemView.apply {
            myName.text = message.author
            myMessageText.text = message.text
            myData.text =
                SimpleDateFormat("HH:mm MMM dd", Locale.getDefault()).format(message.date)
        }
    }

}