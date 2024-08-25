package com.example.islami.ui.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.R

// عملنا هنا كدا بدل من اني اعمل data class  ف عادي عملناها  list  عاديه
class ChapterRecyclerAdapter(private val chapters: List<String>) :
    Adapter<ChapterRecyclerAdapter.ViewHolder>() {
    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.chapter_title)
        val separtor: View = itemView.findViewById(R.id.separtor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int
    //  هنا هو بعتها list  علطول ولا  nullable list فعشان كدا مضطرتش اني اعمل ؟
            = chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val title: String = chapters[position]

        holder.title.setText(title)
        if (position == chapters.size - 1) holder.separtor.visibility = View.GONE;

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(title, position)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(title: String, position: Int)
    }

}