package com.vibelous.iqbaaaaalf.easynoteskotlin.data.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import java.util.*

/**
 * Created by iqbaaaaalf on 12/9/2017.
 */

@Entity(tableName = "note")
@TypeConverters(DateConverter::class)
data class NoteEntity (@ColumnInfo(name = "title") var mTitle: String,
                       @ColumnInfo(name = "description") var mDescription: String,
                       @ColumnInfo(name = "category") var mCategory: String,
                       @ColumnInfo(name = "dueAt") var dueAt: Date,
                       @ColumnInfo(name = "createdAt") var createdAt: Date){

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var mId: Long = 0

}


