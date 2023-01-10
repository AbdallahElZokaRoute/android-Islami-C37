package com.route.islamic37.main_activity.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic37.Constants
import com.route.islamic37.R
import com.route.islamic37.callbacks.OnHadethClickListener
import com.route.islamic37.hadeth_Details.HadethDetailsActivity
import com.route.islamic37.main_activity.main_fragments.adapters.AhadethNameAdapter


class VersesFragment : Fragment() {

    lateinit var ahadethRecyclerView: RecyclerView
    lateinit var ahadethAdapter: AhadethNameAdapter
    lateinit var array : ArrayList<Int>




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ahadethRecyclerView = view.findViewById(R.id.ahadeh_recyclerview)

        var splitContent = readFileText()
        arrayCreation(splitContent.size)
        ahadethAdapter = AhadethNameAdapter(array)
        ahadethRecyclerView.adapter= ahadethAdapter
        ahadethRecyclerView.layoutManager = LinearLayoutManager(context)
        ahadethAdapter.OnHadethClickListener = object : OnHadethClickListener{
            override fun onHadethClick(position: Int) {
               val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
                intent.putExtra(Constants.position_intent, position)
                intent.putExtra(Constants.content_intent, splitContent as ArrayList)
                startActivity(intent)
            }


        }
    }

    fun arrayCreation(split : Int){
        array = ArrayList<Int>()
        for (i in 1 until split){
            array.add(i)
        }

    }

    fun readFileText() : List<String> {
        val fileContent : String = activity?.assets?.open("ahadeth.txt")?.bufferedReader().use { it!!.readText() }

        var splitContent = fileContent.split("#")
        return splitContent

    }




    }
