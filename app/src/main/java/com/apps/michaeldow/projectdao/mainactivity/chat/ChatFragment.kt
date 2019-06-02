package com.apps.michaeldow.projectdao.mainactivity.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.michaeldow.projectdao.R
import com.apps.michaeldow.projectdao.databinding.FragmentChatBinding
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: ChatViewModel
    private lateinit var binding: FragmentChatBinding
    private lateinit var adapter: FirestoreRecyclerAdapter<Chat, ChatViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            findNavController().navigate(R.id.action_chatFragment_to_welcomeFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        binding.viewModel = viewModel

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
        val recyclerView = binding.root.findViewById(R.id.chat_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val options: FirestoreRecyclerOptions<Chat> = FirestoreRecyclerOptions.Builder<Chat>()
            .setQuery(viewModel.getQuery(), Chat::class.java)
            .build()

        adapter = object: FirestoreRecyclerAdapter<Chat, ChatViewHolder>(options) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                return ChatViewHolder(inflater.inflate(R.layout.list_item_chat, parent, false))
            }

            override fun onBindViewHolder(p0: ChatViewHolder, p1: Int, p2: Chat) {
                p0.bind(p2)
                p0.itemView.setOnClickListener {view ->
                    val directions = ChatFragmentDirections.actionChatFragmentToMessageFragment()
                    directions.chatId = p2.id
                    findNavController().navigate(directions)
                }
            }
        }

        recyclerView.adapter = adapter
    }

    private fun setupObservers() {

    }

}