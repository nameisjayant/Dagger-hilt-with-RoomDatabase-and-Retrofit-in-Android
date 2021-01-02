package com.example.roomwithretrofit.ViewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomwithretrofit.Model.Post
import com.example.roomwithretrofit.Repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class PostViewModel @ViewModelInject constructor(private val postRepository: PostRepository) : ViewModel() {

    val getAllPost:LiveData<List<Post>> = postRepository.getAllPost
        .flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)

    fun insert(postList: List<Post>) =viewModelScope.launch {
        postRepository.insert(postList)
    }
       val getData=postRepository.getData()
           .catch { e->
               Log.d("main", "${e.message}")
           }.asLiveData()

}