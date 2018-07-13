package com.pvasilev.uplabs.data.models

data class SearchResult<out T>(val hits: List<T>)