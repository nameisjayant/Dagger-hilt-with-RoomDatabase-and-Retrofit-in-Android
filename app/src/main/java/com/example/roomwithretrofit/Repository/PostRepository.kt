package com.example.roomwithretrofit.Repository

import com.example.roomwithretrofit.Dao.PostDao
import com.example.roomwithretrofit.Model.Post
import com.example.roomwithretrofit.Network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(private val postDao: PostDao,private val apiServiceImp: ApiServiceImp) {

    val getAllPost:Flow<List<Post>> = postDao.getAllPost()

    suspend fun insert(postList: List<Post>) = withContext(Dispatchers.IO){
        postDao.insert(postList)
    }

    fun getData():Flow<List<Post>> = flow {
        val response = apiServiceImp.getAllPost()
        emit(response)
    }.flowOn(Dispatchers.IO)

}