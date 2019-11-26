package com.richardlewan.blogposts.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.richardlewan.blogposts.base.Post

@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val all: List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}