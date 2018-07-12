package com.pvasilev.uplabs.data.net

import com.pvasilev.uplabs.data.models.Post
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UplabsApi {
    @GET("{category}.json")
    fun getPosts(@Path("category") category: String, @Query("days_ago") daysAgo: Int): Single<List<Post>>
}