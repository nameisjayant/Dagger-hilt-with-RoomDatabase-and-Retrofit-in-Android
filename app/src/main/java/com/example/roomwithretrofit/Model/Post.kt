package com.example.roomwithretrofit.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post(val body:String) {

    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}