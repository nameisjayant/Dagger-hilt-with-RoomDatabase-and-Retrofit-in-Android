package com.example.roomwithretrofit.Network

import com.example.roomwithretrofit.Model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getAllPost():List<Post>
}