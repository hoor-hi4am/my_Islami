package com.route.islami.ui.scrrens.main.fragments.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R
import com.route.islami.ui.Constants

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
        suraAdapter = SuraAdapter(Constants.suraList)
        suraRecyclerView.adapter = suraAdapter
    }
}