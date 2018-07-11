package com.pvasilev.uplabs.models

data class Session(val me: User, val followingIds: List<Int>, val upvotedPostsIds: List<Int>)