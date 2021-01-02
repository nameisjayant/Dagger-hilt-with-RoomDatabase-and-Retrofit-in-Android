package com.example.roomwithretrofit.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomwithretrofit.Dao.PostDao
import com.example.roomwithretrofit.Model.Post

@Database(entities = [Post::class], version = 1,exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract  fun getPostDao():PostDao
}