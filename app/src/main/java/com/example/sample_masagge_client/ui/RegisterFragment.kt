package com.example.sample_masagge_client.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sample_masagge_client.R
import com.example.sample_masagge_client.data.MessengerRepository
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    private val messengerRepository = MessengerRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonRegister.setOnClickListener {
            val username = inputUsername.text.toString()
            val firstName = inputLastName.text.toString()
            val lastName = inputLastName.text.toString()

            if (username.isNotBlank() && firstName.isNotBlank() && lastName.isNotBlank()) {
                launch {
                    buttonRegister.visibility = View.GONE
                    loader.visibility = View.VISIBLE
                    messengerRepository.register(username, lastName, firstName)
                        .await()
                        ?.also {
                            Log.i("Register", "successful")
                        } ?: run {
                        Toast.makeText(context, "Error occurred", Toast.LENGTH_SHORT).show()
                    }
                    buttonRegister.visibility = View.VISIBLE
                    loader.visibility = View.GONE
                }

            }
        }
    }
}
