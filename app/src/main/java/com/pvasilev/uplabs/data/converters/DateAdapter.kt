package com.pvasilev.uplabs.data.converters

import android.arch.persistence.room.TypeConverter
import java.util.*

class DateAdapter {
    @TypeConverter
    fun fromTimestamp(time: Long): Date = Date(time)

    @TypeConverter
    fun toTimestamp(date: Date): Long = date.time
}