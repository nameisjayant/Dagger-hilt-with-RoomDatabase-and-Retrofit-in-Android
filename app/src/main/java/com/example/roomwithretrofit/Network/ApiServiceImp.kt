package com.example.roomwithretrofit.Network

import com.example.roomwithretrofit.Model.Post
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllPost():List<Post> = apiService.getAllPost()
}