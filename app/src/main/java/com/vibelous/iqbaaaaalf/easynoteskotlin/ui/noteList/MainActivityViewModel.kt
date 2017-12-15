package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.vibelous.iqbaaaaalf.easynoteskotlin.AppExecutors
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteDao
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity
import com.vibelous.iqbaaaaalf.easynoteskotlin.util.Util
import java.util.*

/**
 * Created by iqbaaaaalf on 12/10/2017.
 */
class MainActivityViewModel(noteDao: NoteDao, executor: AppExecutors) : ViewModel() {

    val TAG: String = this.javaClass.simpleName
    var noteList: LiveData<List<NoteEntity>>
    val mDao: NoteDao = noteDao
    val mExecutor: AppExecutors = executor

    init {
        noteList = getAllNotes()
    }

    fun getAllNotes(): LiveData<List<NoteEntity>>{
        return mDao.getAllNotes()
    }

    /*
        All about util method
     */

    fun getSampleNote(): NoteEntity{
        val randomDate: Date = Util.getTodayPlusDays((1..15).random())
        val today: Date = Util.getTodayPlusDays((0..1).random())

        val newNote: NoteEntity = NoteEntity("judul", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam cursus maximus nisl, sit amet congue odio fermentum in.",
                "Kategori", randomDate, today )

        return newNote
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive - start) +  start




}