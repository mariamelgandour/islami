package com.example.islami.ui.home.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding

class HadethListeAdapter(val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethListeAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemHadethBinding) : RecyclerView.ViewHolder(
        binding.root
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        val separtor: View = binding.separtor
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.chapterTitle.text = hadethList[position].title

        if (position == hadethList.size - 1)
            holder.binding.separtor.visibility = View.GONE
        if (onItemClickListener != null)
            holder.binding.root.setOnClickListener {
                onItemClickListener?.onOtemClick(position, hadeth = hadethList[position])
            }
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onOtemClick(position: Int, hadeth: Hadeth)
    }
}