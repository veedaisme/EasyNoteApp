package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd

import android.arch.lifecycle.ViewModelProviders
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.vibelous.iqbaaaaalf.easynoteskotlin.R
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity
import com.vibelous.iqbaaaaalf.easynoteskotlin.util.InjectorUtils
import com.vibelous.iqbaaaaalf.easynoteskotlin.util.Util
import kotlinx.android.synthetic.main.activity_note_add.*
import java.util.*

class NoteAddActivity : AppCompatActivity() {

    val TAG: String  = this.javaClass.simpleName
    lateinit var mViewmodel: NoteAddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        setUpActionBar()

        setUpViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_done,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_done -> {
                addNewNote()
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun getIntentExtra(): String{
        val intent = getIntent()
        Log.i(TAG, "Today Date : " + intent.getStringExtra("today_date") )
        return intent.getStringExtra("today_date")
    }

    fun addNewNote(){
        val today = Util.getTodayDay()
        val randomDue = Util.getRandomDayFromToday()
        val title = et_addTitle.text.toString()
        val body = et_addBody.text.toString()

        val newNote = NoteEntity(title, body, "Cerita", randomDue ,today)
        mViewmodel.addNote(newNote)
    }

    fun setUpViewModel(){
        val factory = InjectorUtils.provideNoteAddViewModelFactory(this.applicationContext)
        mViewmodel = ViewModelProviders.of(this,factory).get(NoteAddViewModel::class.java)
    }

    /*
        required : override onSupportNavigateUp
     */
    fun setUpActionBar(){

        val upArrow = ContextCompat.getDrawable(this,R.drawable.abc_ic_ab_back_material)
        title = getIntentExtra()

        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.colorMenu), PorterDuff.Mode.SRC_ATOP)
        supportActionBar!!.setHomeAsUpIndicator(upArrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowCustomEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
