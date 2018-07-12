package com.pvasilev.uplabs.data.repositories

import com.pvasilev.uplabs.data.net.UplabsApi
import com.pvasilev.uplabs.data.models.Post
import io.reactivex.Single
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: UplabsApi) {
    fun getPosts(category: String, daysAgo: Int): Single<List<Post>> {
        return api.getPosts(category, daysAgo)
    }
}