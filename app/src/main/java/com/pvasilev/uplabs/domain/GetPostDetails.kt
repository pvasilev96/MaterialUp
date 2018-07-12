package com.pvasilev.uplabs.domain

import com.pvasilev.uplabs.data.models.Post
import com.pvasilev.uplabs.data.repositories.PostRepository
import io.reactivex.Single
import java.util.concurrent.Executor
import javax.inject.Inject

class GetPostDetails @Inject constructor(
        computationExecutor: Executor,
        postComputationExecutor: Executor,
        private val repository: PostRepository
) : UseCase<Post, GetPostDetails.Params>(computationExecutor, postComputationExecutor) {

    override fun buildUseCase(params: Params): Single<Post> {
        return repository.getPost(params.postId)
    }

    class Params(val postId: Int)
}