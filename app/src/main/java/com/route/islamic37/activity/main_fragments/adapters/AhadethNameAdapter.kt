package com.route.islamic37.main_activity.main_fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic37.R
import com.route.islamic37.callbacks.OnHadethClickListener
import com.route.islamic37.callbacks.OnSuraClickListener

class AhadethNameAdapter(var ahadeth : ArrayList<Int>):Adapter<AhadethNameAdapter.HadethNameViewHolder>() {

    lateinit var OnHadethClickListener : OnHadethClickListener

    class HadethNameViewHolder(val itemView : View): ViewHolder(itemView){

         var hadethName : TextView

        init {
            hadethName = itemView.findViewById(R.id.hadethName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethNameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ahadeth_list_item,parent,false)
        return HadethNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadethNameViewHolder, position: Int) {

        holder.hadethName.text = ahadeth[position].toString()
        holder.itemView.setOnClickListener { OnHadethClickListener.onHadethClick(position) }
    }

    override fun getItemCount(): Int {
       return ahadeth.size
    }
}