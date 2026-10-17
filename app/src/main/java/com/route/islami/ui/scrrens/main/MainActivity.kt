
package com.route.islami.ui.scrrens.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islami.R
import com.route.islami.ui.scrrens.main.fragments.hadith.HadithFragment
import com.route.islami.ui.scrrens.main.fragments.quran.QuranFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        openFragment(QuranFragment())
        bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.quranTab -> {
                    openFragment(QuranFragment())
                    true
                }

                R.id.hadithTab -> {
                    openFragment(HadithFragment())
                    true
                }

                R.id.sebhaTab -> {
                    Toast.makeText(
                        this, "Task", Toast.LENGTH_SHORT
                    ).show()
                    false
                }

                R.id.radioTab -> {
                    Toast.makeText(
                        this, "Not implemented yet", Toast.LENGTH_SHORT
                    ).show()
                    false
                }
                else -> false
            }
        }
    }

    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}