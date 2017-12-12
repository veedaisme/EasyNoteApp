package com.vibelous.iqbaaaaalf.easynoteskotlin.ui.adapter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vibelous.iqbaaaaalf.easynoteskotlin.R
import com.vibelous.iqbaaaaalf.easynoteskotlin.data.database.NoteEntity
import java.text.SimpleDateFormat
import java.util.logging.Handler
import java.util.logging.SimpleFormatter

/**
 * Created by iqbaaaaalf on 12/11/2017.
 */

class NoteListAdapter() : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    val TAG: String = this.javaClass.simpleName

    var items: MutableList<NoteEntity>? = null

    companion object {
       const val TYPE_HEADER: Int  = 0
       const val TYPE_NOTE: Int  = 1
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            holder.bind(position, items!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_note, parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return if(items == null) 0 else items!!.size
    }

    fun addAll(newNoteList: List<NoteEntity>){
        items = newNoteList.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int, items: List<NoteEntity>){
            val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
            val tvNote: TextView = itemView.findViewById(R.id.tv_note)
            val tvCategory: TextView = itemView.findViewById(R.id.tv_category)
            val tvDueDate: TextView = itemView.findViewById(R.id.tv_dueDate)

            val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM")
            val dateString: String = sdf.format(items[position].dueAt)

            tvTitle.text = items[position].mTitle
            tvNote.text = items[position].mDescription
            tvCategory.text = "#"+ items[position].mCategory
            tvDueDate.text = dateString
        }
    }




}