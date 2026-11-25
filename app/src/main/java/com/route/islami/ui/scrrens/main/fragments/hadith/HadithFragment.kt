package com.route.islami.ui.scrrens.main.fragments.hadith

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy
import com.route.islami.R
import com.route.islami.ui.model.HadithDM
import com.route.islami.ui.scrrens.hadith_details.HadithDetailsActivity

class HadithFragment : Fragment() {

    var ahadeth: MutableList<HadithDM> = mutableListOf()

    lateinit var hadithAdapter: HadithAdapter
    lateinit var hadithRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadith, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        readAhadethFile()
        initRecycler()
        //و لازم نقرا الاول و بعدين نعرض يعني لازم الترتيب ده
    }

    private fun initRecycler() {
        //بنجيب الريسايكلر فيو و الادابتر و بنربطهم ببعض
        hadithRecyclerView = requireView().findViewById(R.id.hadithRecyclerView)

        hadithAdapter = HadithAdapter(ahadeth){ hadeth ->
            startActivity(Intent(activity, HadithDetailsActivity::class.java).apply{
                putExtra(HadithDetailsActivity.HADETH_KEY, hadeth)
            })
        }
        hadithRecyclerView.adapter = hadithAdapter

        val layoutManager = CarouselLayoutManager(HeroCarouselStrategy())
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        hadithRecyclerView.layoutManager = layoutManager
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(hadithRecyclerView)
    }

    private fun readAhadethFile() {
        val inputStream = requireActivity().assets.open("ahadeth.txt")

        var title = ""
        var content = ""

        inputStream.reader().forEachLine {

            if (title.isEmpty()) {
                title = it
            } else {
                if (it == "#") {
                    ahadeth.add(HadithDM(title, content))
                    title = ""
                    content = ""
                    return@forEachLine
                }

                content += it
            }
        }

        if (title.isNotEmpty()) {
            ahadeth.add(HadithDM(title, content))
        }
    }
}