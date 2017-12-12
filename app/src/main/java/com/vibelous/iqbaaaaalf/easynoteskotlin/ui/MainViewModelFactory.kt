package com.vibelous.iqbaaaaalf.easynoteskotlin.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.vibelous.iqbaaaaalf.easynoteskotlin.AppExecutors
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteDao

/**
 * Created by iqbaaaaalf on 12/12/2017.
 */
class MainViewModelFactory(noteDao: NoteDao, executor: AppExecutors) : ViewModelProvider.Factory {

    var mDao: NoteDao
    var mExecutor: AppExecutors

    init {
        mDao = noteDao
        mExecutor = executor
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(mDao, mExecutor) as T
    }
}