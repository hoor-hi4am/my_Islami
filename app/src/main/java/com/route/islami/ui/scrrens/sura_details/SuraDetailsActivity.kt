package com.route.islami.ui.scrrens.sura_details

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islami.R
import com.route.islami.ui.model.SuraDM

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var nameAr: TextView
    lateinit var nameEn: TextView
    lateinit var sura: SuraDM
    lateinit var backArrow: ImageView
    lateinit var suraContentTextView: TextView
    companion object{
        const val SURA_KEY = "sura"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        initViews()
        initListeners()
        readSuraFile()
    }

    private fun readSuraFile() {
        val fileName = "${sura.index}.txt"
        val inputStream = assets.open("quran/$fileName")
        var suraContent = ""
        var i = 1
        inputStream.reader().forEachLine { line->
            if(line.isNotEmpty()){
                suraContent += "$line {$i}"
                i++
            }
        }
        suraContentTextView.text = suraContent
    }

    private fun initListeners() {
       backArrow.setOnClickListener {
           finish()
       }
    }

    private fun initViews() {
        sura = (if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getSerializableExtra(SURA_KEY, SuraDM::class.java) else intent.getSerializableExtra(SURA_KEY) as SuraDM)!!
        nameAr = findViewById(R.id.suraNameAr)
        nameEn = findViewById(R.id.suraNameEn)
        backArrow = findViewById(R.id.icBackArrow)
        suraContentTextView = findViewById(R.id.suraContent)

        nameAr.text = sura.nameAr
        nameEn.text = sura.nameEn
    }
}