package com.route.islamic37.activity.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37.Constants
import com.route.islamic37.R
import com.route.islamic37.activity.main_fragments.adapters.hadethAdapter
import com.route.islamic37.hadeethDetails

class VersesFragment : Fragment() {

    lateinit var hadeeth_recyclerView: RecyclerView
    lateinit var hadeeth_adapter: hadethAdapter
    lateinit var hadeth_Data:ArrayList<String>



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hadeeth_recyclerView=view.findViewById(R.id.hadeeth_recyclerView)
        initAhadeeth()
        hadeeth_adapter= hadethAdapter(hadeth_Data)
        hadeeth_recyclerView.adapter=hadeeth_adapter

        hadeeth_adapter.hadeethonCLickListener=object :hadethAdapter.hadethOnClickListener{
            override fun hadethOnClicked(position: Int, item: String) {
                val intent1= Intent(requireContext(),hadeethDetails::class.java)
                intent1.putExtra(Constants.key_hadeethPosition,position)
                startActivity(intent1)
            }
        }
    }

    fun initAhadeeth(){
        hadeth_Data= ArrayList()
        for(i in 0..49){
            hadeth_Data.add("الحديث رقم  ${i+1}")
        }
    }
}