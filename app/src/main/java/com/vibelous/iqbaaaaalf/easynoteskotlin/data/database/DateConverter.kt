package com.vibelous.iqbaaaaalf.easynoteskotlin.data.database

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by iqbaaaaalf on 12/10/2017.
 */
class DateConverter{
        @TypeConverter
        fun toDate(value: Long?): Date? {
            return if (value == null) null else Date(value)
        }

        @TypeConverter
        fun toTimeStamp(value: Date?): Long? {
            return if(value == null) null else value.time
        }
}