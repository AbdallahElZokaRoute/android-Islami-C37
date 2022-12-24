package com.route.islamic37.main_activity.main_fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic37.R
import com.route.islamic37.callbacks.OnSuraClickListener

class SurasNameAdapter(var suras: List<String>, var count: Int = 286) :
    Adapter<SurasNameAdapter.SurasNamesViewHolder>() {

    var onSuraClickListener: OnSuraClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurasNamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quran_list_item, parent, false)
        return SurasNamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurasNamesViewHolder, position: Int) {
        holder.suraName.text = suras.get(position)
        holder.suraContentCount.text = "$count"
        holder.itemView.setOnClickListener {
            onSuraClickListener?.onSuraClick(position)
        }

    }

    override fun getItemCount(): Int {
        return suras.size
    }

    class SurasNamesViewHolder(val itemView: View) : ViewHolder(itemView) {
        var suraName: TextView
        var suraContentCount: TextView


        init {
            suraName = itemView.findViewById(R.id.suras_name)
            suraContentCount = itemView.findViewById(R.id.suras_content_count)
        }

    }


}