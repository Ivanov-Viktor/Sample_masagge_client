package com.example.sample_masagge_client.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sample_masagge_client.R

class ChatFragment : Fragment() {

    companion object {
        const val USERNAME = "username"
    }

    private val username =
        arguments?.getString(USERNAME) ?: throw IllegalArgumentException("No username passed")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }
}