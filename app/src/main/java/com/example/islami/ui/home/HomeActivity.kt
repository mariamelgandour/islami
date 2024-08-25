package com.example.islami.ui.home

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.ui.home.hadeth.HadethFragment
import com.example.islami.ui.home.quran.QuranFragment
import com.example.islami.ui.home.radio.RadioFragment
import com.example.islami.ui.home.tasbeh.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        bottomNav = findViewById(R.id.navition_home)

        bottomNav.setOnItemSelectedListener {

                item ->
            when (item.itemId) {
                R.id.navition_radio -> {
                    showTab(RadioFragment())
                }

                R.id.navigation_sebha -> {
                    showTab(TasbehFragment())
                }

                R.id.navigation_hadeth -> {
                    showTab(HadethFragment())
                }

                R.id.navigation_quran -> {
                    showTab(QuranFragment())
                }
            }
            return@setOnItemSelectedListener true
        }

        bottomNav.selectedItemId = R.id.navigation_quran

    }

    fun showTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_contianer, fragment)
            .commit()
    }

}