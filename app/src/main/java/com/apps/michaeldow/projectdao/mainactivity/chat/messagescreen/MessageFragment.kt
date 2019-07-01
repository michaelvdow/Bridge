package com.apps.michaeldow.projectdao.mainactivity.chat.messagescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.michaeldow.projectdao.R
import com.apps.michaeldow.projectdao.databinding.FragmentMessageBinding
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class MessageFragment : Fragment() {

    private lateinit var viewModel: MessageViewModel
    private lateinit var binding: FragmentMessageBinding
    private lateinit var adapter: FirestoreRecyclerAdapter<Message, RecyclerView.ViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)
        binding.viewModel = viewModel
        val args: MessageFragmentArgs by navArgs()
        viewModel.otherUser = args.chatId


        setupRecyclerView()
        setupObservers()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.root.findViewById(R.id.message_recycler_view) as RecyclerView
        val linearLayout = LinearLayoutManager(context)
        linearLayout.stackFromEnd = true
        recyclerView.layoutManager = linearLayout

        val options: FirestoreRecyclerOptions<Message> = FirestoreRecyclerOptions.Builder<Message>()
            .setQuery(viewModel.getQuery(viewModel.otherUser), Message::class.java)
            .build()

        // TODO: Get user id from database
        val userId = 1

        adapter = object: FirestoreRecyclerAdapter<Message, RecyclerView.ViewHolder>(options) {
            val text = "text"
            val incomingText = 0
            val outgoingText = 1

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                if (viewType == incomingText) {
                    return MessageIncomingTextViewHolder(inflater.inflate(R.layout.list_item_message_incoming_text, parent, false))
                } else {
                    return MessageOutgoingTextViewHolder(inflater.inflate(R.layout.list_item_message_outgoing_text, parent, false))
                }
            }

            override fun getItemViewType(position: Int): Int {
                println(getItem(position).type)
                println(getItem(position).message)
                if (getItem(position).type == text && getItem(position).from == userId) {
                    return outgoingText
                } else {
                    return incomingText
                }
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, p2: Message) {
                when(holder) {
                    is MessageIncomingTextViewHolder -> holder.bind(p2)
                    is MessageOutgoingTextViewHolder -> holder.bind(p2)
                }
            }
        }

        recyclerView.adapter = adapter
    }

    private fun setupObservers() {

    }

}