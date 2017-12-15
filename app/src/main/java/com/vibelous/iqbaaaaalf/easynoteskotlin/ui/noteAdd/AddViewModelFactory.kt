package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vibelous.iqbaaaaalf.easynoteskotlin.AppExecutors
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteDao

/**
 * Created by iqbaaaaalf on 12/15/2017.
 */
class AddViewModelFactory(noteDao: NoteDao, executor: AppExecutors) : ViewModelProvider.Factory {

    val mDao = noteDao
    val mExecutor = executor

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteAddViewModel(mDao, mExecutor) as T
    }
}