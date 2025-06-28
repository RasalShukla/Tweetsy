package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {

   private val _categories = MutableStateFlow<List<String>>(emptyList())
   val categories : StateFlow<List<String>>
       get() = _categories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets : StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories(){
        var response = tweetsyAPI.getCategories()
        if (response.isSuccessful && response.body() != null){
              _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category : String){
        var paramCategory : String = "tweets[?(@.category == \"$category\")]"
        var response = tweetsyAPI.getTweets(paramCategory)
        if (response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }
}