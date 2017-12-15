package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.noteAdd

import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.TextView
import android.widget.Toolbar
import com.vibelous.iqbaaaaalf.easynoteskotlin.R
import kotlinx.android.synthetic.main.add_action_bar.*

class NoteAddActivity : AppCompatActivity() {
    val TAG: String  = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        setUpActionBar()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_done,menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun getIntentExtra(): String{
        val intent = getIntent()
        Log.i(TAG, "Today Date : " + intent.getStringExtra("today_date") )
        return intent.getStringExtra("today_date")
    }

    /*
        required : override onSupportNavigateUp
     */
    fun setUpActionBar(){

//        val title = findViewById<TextView>(R.id.toolbar_title_add)
        val upArrow = ContextCompat.getDrawable(this,R.drawable.abc_ic_ab_back_material)

//        setSupportActionBar(toolbar_add)

        title = getIntentExtra()

        upArrow.setColorFilter(ContextCompat.getColor(this,R.color.colorMenu), PorterDuff.Mode.SRC_ATOP)
        supportActionBar!!.setHomeAsUpIndicator(upArrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowCustomEnabled(true)


    }

}
