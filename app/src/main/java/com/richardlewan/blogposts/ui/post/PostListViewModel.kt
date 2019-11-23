package com.richardlewan.blogposts.ui.post

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.richardlewan.blogposts.R
import com.richardlewan.blogposts.model.BaseViewModel
import com.richardlewan.blogposts.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Note: See inject() function in parent class (!)
 */
class PostListViewModel: BaseViewModel(){
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    init{
        loadPosts()
    }

    private fun loadPosts(){
        subscription = postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { onRetrievePostListSuccess() },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(){

    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }

    /**
     * Dispose the subscription when the ViewModel (this) is no longer used.
     */
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}