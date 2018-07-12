package com.pvasilev.uplabs.data.models

data class Config(val authenticityToken: String, val search: Search)

data class Search(val algolia: Algolia, val indices: Map<String, String>)

data class Algolia(val appId: String, val apiKey: String)