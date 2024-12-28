package com.example.mvvm.api

import com.example.mvvm.model.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TweetsyApi {
    @GET("/v3/b/67667e3cacd3cb34a8bd37d8?meta=false")
   suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>
}