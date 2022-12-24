package com.route.islamic37.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamic37.R
import com.route.islamic37.main_activity.main_fragments.QuranFragment
import com.route.islamic37.main_activity.main_fragments.RadioFragment
import com.route.islamic37.main_activity.main_fragments.TasbeehFragment
import com.route.islamic37.main_activity.main_fragments.VersesFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.quran) {
                pushFragment(QuranFragment())
            } else if (it.itemId == R.id.ahadeth) {
                pushFragment(VersesFragment())

            } else if (it.itemId == R.id.tasbeeh) {
                pushFragment(TasbeehFragment())

            } else if (it.itemId == R.id.radio) {
                pushFragment(RadioFragment())
            }

            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.quran
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragments, fragment)
            .commit()


    }
}