package com.route.islami.ui.scrrens.main.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R
import com.route.islami.ui.Constants
import com.route.islami.ui.scrrens.sura_details.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var suraRecyclerView: RecyclerView
    lateinit var suraAdapter: SuraAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSuraRecyclerView(view)
    }

    private fun initSuraRecyclerView(view: View) {
        suraRecyclerView = view.findViewById(R.id.suraRecyclerView)
        //خلاص معاك الريسايكلر فيو روح اربطه بالادابتر
        suraAdapter = SuraAdapter(Constants.suraList){ sura->
            val intent = Intent(context, SuraDetailsActivity::class.java)
            //ما ينفعش زي ما كنا متعودين نكتب thisعشان الفراجمنت مش كونتكست الفراجمنت دي حاجة جوه اكتيفتي
            intent.putExtra("sura", sura)
            startActivity(intent)
        } //الاقواس دي كاني بعت الفانكشن عشان كده بخلي الفانكشن دايما اخر باراميتر عشان اعمل الحركة دي
        suraRecyclerView.adapter = suraAdapter
    }
}