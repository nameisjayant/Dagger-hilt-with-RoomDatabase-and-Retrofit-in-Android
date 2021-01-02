package com.example.roomwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomwithretrofit.Adapter.PostAdapter
import com.example.roomwithretrofit.Model.Post
import com.example.roomwithretrofit.ViewModel.PostViewModel
import com.example.roomwithretrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val postViewModel:PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initRecyclerView()
        postViewModel.getData.observe(this, Observer { response->
            postViewModel.insert(response)
        })
        postViewModel.getAllPost.observe(this, Observer { response->
            binding.recyclerview.visibility=View.VISIBLE
            binding.progressBar.visibility=View.GONE
            postAdapter.setPost(response as ArrayList<Post>)
        })

    }

    private fun initRecyclerView() {
        postAdapter= PostAdapter(this, ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}