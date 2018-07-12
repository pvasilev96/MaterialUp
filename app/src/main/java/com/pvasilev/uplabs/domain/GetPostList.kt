package com.pvasilev.uplabs.domain

import com.pvasilev.uplabs.data.repositories.PostRepository
import com.pvasilev.uplabs.data.models.Post
import io.reactivex.Single
import java.util.concurrent.Executor
import javax.inject.Inject

class GetPostList @Inject constructor(
        computationExecutor: Executor,
        postComputationExecutor: Executor,
        private val repository: PostRepository
) : UseCase<List<Post>, GetPostList.Params>(computationExecutor, postComputationExecutor) {

    override fun buildUseCase(params: Params): Single<List<Post>> {
        return repository.getPosts(params.category, params.daysAgo)
    }

    class Params(val category: String, val daysAgo: Int)
}