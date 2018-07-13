package com.pvasilev.uplabs.data.converters

import com.pvasilev.uplabs.data.models.Shade
import com.squareup.moshi.FromJson

class ShadeAdapter {
    @FromJson
    fun fromJson(palette: List<String>): List<Shade> {
        return palette.chunked(2) {
            val (name, hexValue) = it
            Shade(name, hexValue)
        }
    }
}