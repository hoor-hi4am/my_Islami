package com.route.islami.ui.scrrens.main.fragments.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R
import com.route.islami.ui.model.HadithDM

class HadithAdapter(val ahadeth: List<HadithDM>, val onClick: (HadithDM) -> Unit): RecyclerView.Adapter<HadithAdapter.HadithViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadithViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadith,parent,false)//I wanna understand it
        return HadithViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HadithViewHolder,
        position: Int
    ) {
        val hadeth = ahadeth[position]
        holder.hadethTitle.text = hadeth.title
        holder.hadethContent.text = hadeth.content
        holder.itemView.setOnClickListener {
            onClick(hadeth)
        }
    }

    override fun getItemCount(): Int = ahadeth.size
    class HadithViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val hadethTitle: TextView = itemView.findViewById(R.id.hadethTitle)
        val hadethContent: TextView = itemView.findViewById(R.id.hadethContent)
    }
}