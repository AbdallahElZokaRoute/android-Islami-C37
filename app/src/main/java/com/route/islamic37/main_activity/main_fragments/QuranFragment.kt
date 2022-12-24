package com.route.islamic37.main_activity.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37.R
import com.route.islamic37.callbacks.OnSuraClickListener
import com.route.islamic37.data.model.ArSuras
import com.route.islamic37.main_activity.main_fragments.adapters.SurasNameAdapter

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
        quranAdapter = SurasNameAdapter(ArSuras)
        quranRecyclerView.adapter = quranAdapter
        quranRecyclerView.layoutManager = LinearLayoutManager(context)
        quranAdapter.onSuraClickListener = object : OnSuraClickListener {
            override fun onSuraClick(position: Int) {
                //val intent1 = Intent(this@QuranFragment,)
            }

        }
    }
}