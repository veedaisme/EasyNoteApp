package com.vibelous.iqbaaaaalf.easynoteskotlin.data.database

import android.arch.persistence.room.*
import android.content.Context

/**
 * Created by iqbaaaaalf on 12/10/2017.
 */
@Database(entities = arrayOf(NoteEntity::class), version = 1)
abstract class EasyNoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        val databaseName: String = "note"
        @JvmField val LOCK: Object = Object()
        @Volatile var sInstance: EasyNoteDatabase? = null

        fun getInstance(context: Context): EasyNoteDatabase? {
            if(sInstance == null){
                synchronized(LOCK){
                    if(sInstance == null){
                        sInstance = Room.databaseBuilder(context.applicationContext,EasyNoteDatabase::class.java,EasyNoteDatabase.databaseName).build()
                    }
                }
            }
            return sInstance
        }
    }
}