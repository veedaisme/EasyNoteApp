package com.vibelous.iqbaaaaalf.easynoteskotlin.util

import android.content.Context
import com.vibelous.iqbaaaaalf.easynoteskotlin.AppExecutors
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.EasyNoteDatabase
import com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd.AddViewModelFactory
import com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd.NoteAddViewModel
import com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteList.MainViewModelFactory

/**
 * Created by iqbaaaaalf on 12/12/2017.
 */
class InjectorUtils {
    companion object {
        fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
            val executors: AppExecutors = AppExecutors.getInstance()!!
            val database: EasyNoteDatabase = EasyNoteDatabase.getInstance(context.applicationContext)!!
            return MainViewModelFactory(database.noteDao, executors)
        }

        fun provideNoteAddViewModelFactory(context: Context): AddViewModelFactory{
            val executors: AppExecutors = AppExecutors.getInstance()!!
            val database: EasyNoteDatabase = EasyNoteDatabase.getInstance(context.applicationContext)!!
            return AddViewModelFactory(database.noteDao, executors);
        }


    }
}