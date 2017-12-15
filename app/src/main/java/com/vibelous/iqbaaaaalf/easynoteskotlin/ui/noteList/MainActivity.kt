package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.vibelous.iqbaaaaalf.easynoteskotlin.R
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity
import com.vibelous.iqbaaaaalf.easynoteskotlin.ui.adapter.NoteListAdapter
import com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd.NoteAddActivity
import com.vibelous.iqbaaaaalf.easynoteskotlin.util.InjectorUtils
import com.vibelous.iqbaaaaalf.easynoteskotlin.util.Util

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String  = this.javaClass.simpleName
    lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

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
            addNewNote()
//            Snackbar.make(view, "Successfully Add Note", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
        }
    }

    fun addNewNote(){
        val today = Util.getSimpleDate(Util.getTodayDay())
        Log.i(TAG, "Today date : " + today)
        val intent = MainActivity.newIntent(this, today)
        startActivity(intent)
    }

    companion object {
        private val INTENT_TODAY_DATE = "today_date"

        fun newIntent(context: Context, date: String): Intent{
            val intent = Intent(context, NoteAddActivity::class.java)
            intent.putExtra(INTENT_TODAY_DATE, date)
            return intent
        }
    }

}
