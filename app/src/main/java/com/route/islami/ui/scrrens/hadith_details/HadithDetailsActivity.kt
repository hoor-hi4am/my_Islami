package com.route.islami.ui.scrrens.hadith_details

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.R
import com.route.islami.ui.model.HadithDM
import kotlin.jvm.java

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var nameAr: TextView
    lateinit var backArrow: ImageView
    lateinit var hadethContentTextView: TextView
    lateinit var hadeth: HadithDM

    companion object {
        const val HADETH_KEY = "hadeth"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadith_details)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        backArrow.setOnClickListener {
            finish()
        }
    }

    private fun initViews() {
        hadeth =
            (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getSerializableExtra(
                HADETH_KEY,
                HadithDM::class.java
            ) else intent.getSerializableExtra(HADETH_KEY) as HadithDM)!!

        nameAr = findViewById(R.id.hadethNameAr)
        backArrow = findViewById(R.id.icBackArrow)
        hadethContentTextView = findViewById(R.id.hadethContent)
        nameAr.text = hadeth.title
        hadethContentTextView.text = hadeth.content
    }
}