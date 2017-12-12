package com.vibelous.iqbaaaaalf.easynoteskotlin.data

import android.arch.lifecycle.LiveData
import android.util.Log
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteDao
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity
import java.util.*
import java.util.concurrent.Executors
import kotlin.collections.ArrayList

/**
 * Created by iqbaaaaalf on 12/12/2017.
 */

/*
    Not Used For Now because still have no data from network so repository isn't needed
 */

class EasyNoteRepository(noteDao: NoteDao, executors: Executors){

    val LOCK: Object = Object()
    val TAG: String = this.javaClass.simpleName
    @Volatile var sInstance: EasyNoteRepository? = null

    var mNoteDao: NoteDao
    var mCurrentData: LiveData<List<NoteEntity>>
    var mExecutors: Executors

    init {
        mNoteDao = noteDao
        mExecutors = executors
        mCurrentData = getAllNotes()
    }

    @Synchronized fun getInstance(noteDao: NoteDao, executors: Executors): EasyNoteRepository? {
        if(sInstance == null){
            synchronized(LOCK){
                if(sInstance == null){
                    sInstance = EasyNoteRepository(noteDao, executors)
                    Log.d(TAG, "Made new Repository")
                }
            }
        }
        return sInstance
    }

    /**
     * Database Related
     */

    fun getAllNotes(): LiveData<List<NoteEntity>>{
        return mNoteDao.getAllNotes()
    }

}