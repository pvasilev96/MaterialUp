package com.pvasilev.uplabs.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.pvasilev.uplabs.data.models.Post
import io.reactivex.Single

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun get(): Single<List<Post>>

    @Query("SELECT * FROM posts WHERE id = :postId")
    fun getById(postId: Int): Single<Post>

    @Query("SELECT * FROM posts WHERE id IN (:postIds)")
    fun getByIds(postIds: List<Int>): Single<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(posts: List<Post>)
}