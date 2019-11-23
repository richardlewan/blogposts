package com.richardlewan.blogposts.ui.post

import androidx.lifecycle.MutableLiveData
import com.richardlewan.blogposts.base.Post
import com.richardlewan.blogposts.model.BaseViewModel

class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }
}