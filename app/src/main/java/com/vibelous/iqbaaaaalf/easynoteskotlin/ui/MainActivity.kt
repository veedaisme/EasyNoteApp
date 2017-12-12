package com.vibelous.iqbaaaaalf.easynoteskotlin.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.vibelous.iqbaaaaalf.easynoteskotlin.R
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity
import com.vibelous.iqbaaaaalf.easynoteskotlin.ui.adapter.NoteListAdapter
import com.vibelous.iqbaaaaalf.easynoteskotlin.util.InjectorUtils

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String  = this.javaClass.simpleName
    var counter:Int = 0
    lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val factory: MainViewModelFactory = InjectorUtils.provideMainViewModelFactory(this.applicationContext)
        mViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        val mRecycleView: RecyclerView  = findViewById<RecyclerView>(R.id.rv_note)
        mRecycleView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val mAdapter = NoteListAdapter()

        mRecycleView.adapter = mAdapter

        mViewModel.noteList.observe(this, Observer<List<NoteEntity>> {
            noteList ->
            if(noteList != null) {
                Log.i(TAG, "Data Observed Size: " + noteList.size)
                mAdapter.addAll(noteList)
            }
        })

        fab.setOnClickListener { view ->
            mViewModel.addNote()
            Snackbar.make(view, "Successfully Add Note", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
