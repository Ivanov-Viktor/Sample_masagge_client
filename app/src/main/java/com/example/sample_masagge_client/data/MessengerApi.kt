package com.example.sample_masagge_client.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MessengerApi {
    companion object {
        const val HOST = "https://sample-message-server.herokuapp.com"
    }

    @POST(value = "/register")
    fun register(@Body user: User): Call<ApiResponse>

    @GET(value = "/users")
    fun getAllUsers(): Call<List<User>>

    @GET(value = "/allMessages")
    fun getAllMessages(): Call<List<Message>>

    @POST(value = "/postMessages")
    fun postMessage(@Body messageRequest: MessageRequest): Call<ApiResponse>

    @GET(value = "/lastMessages")
    fun getLastMessages(@Query("sinceId") sinceId: Int): Call<List<Message>>

}