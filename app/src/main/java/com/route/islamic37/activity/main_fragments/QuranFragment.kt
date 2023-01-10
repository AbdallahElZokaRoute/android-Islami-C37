package com.route.islamic37.activity.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37.Constants
import com.route.islamic37.R
import com.route.islamic37.callbacks.OnSuraClickListener
import com.route.islamic37.data.model.ArSuras
import com.route.islamic37.activity.main_fragments.adapters.SurasNameAdapter
import com.route.islamic37.design_patterns.Main
import com.route.islamic37.quran_details.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var quranRecyclerView: RecyclerView
    lateinit var quranAdapter: SurasNameAdapter

    //
    /*
        Version Control System
            Git ->
            Problems:-
            1- Standalone
                -> Hardware Failure ->
                ->  1- Instead of bottom Navigation view -> Navigation Drawer
                        Navigation Drawer
                            Double
             2- Work with team ->Flutter Repo
                1- Migration of the source code

          Solutions :
               Git & Github:-
                Version 1.0
                Version 1.1 "Changed From Bottom NavigationView to Drawer"
                Invert to version 1.0

                Github:-  Web Server hosted by git

               // Open Source


     */
    lateinit var switchModeButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.framgnet_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.quran_recycler_view)
        switchModeButton = view.findViewById(R.id.switch_mode)
        val main = Main()
        main.doOperations()
        main.doOperations2()
        switchModeLogic()
        quranAdapter = SurasNameAdapter(ArSuras)
        quranRecyclerView.adapter = quranAdapter
        quranRecyclerView.layoutManager = LinearLayoutManager(context)
        quranAdapter.onSuraClickListener2 = { position, suraName ->
            val intent1 = Intent(requireActivity(), SuraDetailsActivity::class.java)
            intent1.putExtra(Constants.EXTRA_SURA_POSITION, position)
            intent1.putExtra(Constants.EXTRA_SURA_NAME_KEY, suraName)
            startActivity(intent1)
        }

    }

    fun switchModeLogic() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchModeButton.text = "Light"

        } else {
            switchModeButton.text = "Dark"
        }
        switchModeButton.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchModeButton.text = "Dark"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchModeButton.text = "Light"
            }

        }

    }
}