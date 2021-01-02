package com.example.roomwithretrofit.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomwithretrofit.Model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postList: List<Post>)

    @Query("SELECT * FROM post ORDER BY id ASC")
    fun getAllPost():Flow<List<Post>>

}