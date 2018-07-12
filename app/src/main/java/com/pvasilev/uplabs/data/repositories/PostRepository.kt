package com.pvasilev.uplabs.data.repositories

import com.pvasilev.uplabs.data.db.PostDao
import com.pvasilev.uplabs.data.net.UplabsApi
import com.pvasilev.uplabs.data.models.Post
import io.reactivex.Single
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: UplabsApi, private val dao: PostDao) {
    fun getPosts(category: String, daysAgo: Int): Single<List<Post>> {
        return api.getPosts(category, daysAgo)
    }

    fun getPost(postId: Int): Single<Post> {
        return dao.getById(postId)
    }
}