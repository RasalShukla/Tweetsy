package com.example.tweetsy.api

import com.example.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface TweetsyAPI {

    @GET("/v3/b/6859edaa8960c979a5b02500?meta=false")
    @Headers(
        "X-Master-Key: \$2a\$10\$O3YlGHll0OKYqxdFLwjj7eBRIR6gf6icfg9RT9r2rzy8AH6QbnORq"
    )
    suspend fun getTweets(@Header("X-JSON-Path") category : String) : Response<List<TweetListItem>>

    @GET("/v3/b/6859edaa8960c979a5b02500?meta=false")
    @Headers(
        "X-JSON-Path: tweets..category",
        "X-Master-Key: \$2a\$10\$O3YlGHll0OKYqxdFLwjj7eBRIR6gf6icfg9RT9r2rzy8AH6QbnORq"
    )
    suspend fun getCategories(): Response<List<String>>
}
