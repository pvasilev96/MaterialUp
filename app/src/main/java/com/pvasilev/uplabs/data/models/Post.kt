package com.pvasilev.uplabs.data.models

import com.squareup.moshi.Json
import java.util.*

data class Post(
        val id: Int,
        @Json(name = "name") val title: String,
        @Json(name = "description_without_html") val description: String,
        @Json(name = "animated_teaser_url") val teaser: String,
        @Json(name = "category_friendly_name") val category: String,
        @Json(name = "subcategory_friendly_name") val subcategory: String,
        @Json(name = "serialized_submitter") val submitter: User,
        @Json(name = "serialized_upvoters") val upvoters: List<User>,
        @Json(name = "serialized_tools") val tools: List<Tool>,
        @Json(name = "serialized_fonts") val fonts: List<Font>,
        @Json(name = "palette") val colors: List<Shade>,
        @Json(name = "showcased_at") val showcasedAt: Date,
        @Json(name = "votes_count") val votes: Int,
        @Json(name = "views_count") val views: Int
)

data class Shade(val name: String, val hexValue: String)

data class Tool(val name: String, @Json(name = "friendly_name") val friendlyName: String)

data class Font(val name: String, @Json(name = "friendly_name") val friendlyName: String)