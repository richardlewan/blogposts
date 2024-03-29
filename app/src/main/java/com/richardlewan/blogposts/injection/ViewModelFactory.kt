package com.richardlewan.blogposts.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.richardlewan.blogposts.model.database.AppDatabase
import com.richardlewan.blogposts.ui.post.PostListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(db.postDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}