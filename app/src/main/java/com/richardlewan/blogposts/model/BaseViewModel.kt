package com.richardlewan.blogposts.model

import androidx.lifecycle.ViewModel
import com.richardlewan.blogposts.injection.component.DaggerViewModelInjector
import com.richardlewan.blogposts.injection.component.ViewModelInjector
import com.richardlewan.blogposts.injection.module.NetworkModule
import com.richardlewan.blogposts.ui.post.PostListViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}