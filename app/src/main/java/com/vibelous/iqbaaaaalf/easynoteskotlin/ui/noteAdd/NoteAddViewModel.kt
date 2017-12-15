package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd

import android.arch.lifecycle.ViewModel
import com.vibelous.iqbaaaaalf.easynoteskotlin.AppExecutors
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteDao
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity

/**
 * Created by iqbaaaaalf on 12/15/2017.
 */
class NoteAddViewModel(noteDao: NoteDao, executor: AppExecutors) : ViewModel() {

    val mDao = noteDao
    val mExecutor = executor

    fun addNote(newNote: NoteEntity){
        mExecutor.diskIO.execute {
            mDao.insertNote(newNote);
        }
    }

}