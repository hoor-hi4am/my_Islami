package com.route.islami.ui.scrrens.main.fragments.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R
import com.route.islami.ui.model.SuraDM
import com.route.islami.ui.scrrens.main.fragments.quran.SuraAdapter.SuraViewHolder

class SuraAdapter(val suras: List<SuraDM>): RecyclerView.Adapter<SuraAdapter.SuraViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura, parent, false)
        return SuraViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SuraViewHolder,
        position: Int
    ) {
        val sura = suras[position] //محتاج اجيب الاول السورة
        //ناقص ان انا املا التيكست فيوز و هو باعت هولدر
        holder.suraNumber.text = "${sura.index}"
        holder.suraNameEn.text = sura.nameEn
        holder.suraNameAr.text = sura.nameAr
        holder.suraVerses.text = "${sura.versesCount} Verses"
    }

    override fun getItemCount(): Int = suras.size

    class SuraViewHolder(view: View): RecyclerView.ViewHolder(view){
        val suraNumber: TextView = view.findViewById(R.id.suraNumber)
        val suraNameEn: TextView = view.findViewById(R.id.suraNameEn)
        val suraVerses: TextView = view.findViewById(R.id.suraVerses)
        val suraNameAr: TextView = view.findViewById(R.id.suraNameAr)
    }
}