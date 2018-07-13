package com.pvasilev.uplabs.data.net

import com.pvasilev.uplabs.data.models.Post
import com.pvasilev.uplabs.data.models.SearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface UplabsApi {
    @GET("{category}.json")
    fun getPosts(@Path("category") category: String, @Query("days_ago") daysAgo: Int): Single<List<Post>>

    @GET("https://{appId}-dsn.algolia.net/1/indexes/{indexName}")
    fun getPostsByQuery(
            @Header("X-Algolia-Application-Id") @Path("appId") appId: String,
            @Header("X-Algolia-API-Key") apiKey: String,
            @Path("indexName") indexName: String,
            @Query("query") query: String
    ): Single<SearchResult<Post>>
}