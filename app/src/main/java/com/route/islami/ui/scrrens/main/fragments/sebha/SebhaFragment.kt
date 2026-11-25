package com.route.islami.ui.scrrens.main.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islami.R

class SebhaFragment : Fragment() {
    lateinit var sebhaBody: ImageView
    lateinit var sebhaText: TextView
    lateinit var sebhaNum: TextView

    var counter = 0
    var dhikrIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSebha()
        updateDhikr()
    }
    private fun updateDhikr() {
        when (dhikrIndex) {
            0 -> sebhaText.text = "سبحان الله"
            1 -> sebhaText.text = "الحمد لله"
            2 -> sebhaText.text = "لا إله إلا الله"
            3 -> sebhaText.text = "الله أكبر"
        }
    }
    private fun initSebha(){
        sebhaBody = requireView().findViewById(R.id.sebhaBody)
        sebhaText = requireView().findViewById(R.id.sebhaText)
        sebhaNum = requireView().findViewById(R.id.sebhaNum)

        sebhaBody.setOnClickListener {
            sebhaBody.rotation += 10f
            counter++
            if (counter == 33) {
                counter = 0
                dhikrIndex = (dhikrIndex + 1) % 4
                updateDhikr()
            }
            sebhaNum.text = counter.toString()
        }
    }
}