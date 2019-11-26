package com.richardlewan.blogposts.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.richardlewan.blogposts.base.Post
import com.richardlewan.blogposts.model.PostDao

@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}