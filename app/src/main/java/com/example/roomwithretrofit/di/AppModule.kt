package com.example.roomwithretrofit.di

import android.content.Context
import androidx.room.Room
import com.example.roomwithretrofit.Dao.PostDao
import com.example.roomwithretrofit.Database.PostDatabase
import com.example.roomwithretrofit.Network.ApiService
import com.example.roomwithretrofit.Network.ApiServiceImp
import com.example.roomwithretrofit.Repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context):PostDatabase =
        Room.databaseBuilder(context,PostDatabase::class.java,"postDatabase")
            .build()

    @Provides
    fun providesPostDao(postDatabase: PostDatabase):PostDao =
        postDatabase.getPostDao()

    @Provides
    fun providesPostRepository(postDao: PostDao,apiServiceImp: ApiServiceImp):PostRepository =
        PostRepository(postDao,apiServiceImp)

    @Provides
    fun providesBaseUrl():String="https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseUrl:String) : Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesApiService(retrofit: Retrofit):ApiService =
        retrofit.create(ApiService::class.java)
}