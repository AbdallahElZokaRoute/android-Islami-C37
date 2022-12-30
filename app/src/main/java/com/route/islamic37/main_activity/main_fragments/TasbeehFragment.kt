package com.route.islamic37.main_activity.main_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islamic37.R
import com.route.islamic37.callbacks.OnZekeClickListener

class TasbeehFragment : Fragment() {
    lateinit var tasbeeh :ImageView
    lateinit var text_count : TextView
    lateinit var text_zekr : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbeeh =view.findViewById(R.id.tasbeeh)
        text_count=view.findViewById(R.id.count)
        text_zekr=view.findViewById(R.id.zekr)
        var counter = 0
        var count =0
        tasbeeh.setOnClickListener {


            for(i in 1.. 1){
                if (counter<33 || counter ==33) {

                    text_count.setText("" + counter)
                    text_zekr.setText("سبحان الله")
                    counter++

                }else if(counter>33 && counter <67){



                    text_count.setText("" + count)
                    text_zekr.setText("الله اكبر")
                    counter ++
                    count++

                }


        }



    }
}
}