package com.route.islamic37.main_activity.main_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.route.islamic37.Constants
import com.route.islamic37.R


class TasbeehFragment : Fragment() {

    lateinit var image : ImageButton
    lateinit var counterXml : TextView
    lateinit var phase : TextView
     var counter : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.sebha_img)
        counterXml = view.findViewById(R.id.counter)
        counterXml.text = "$counter"
        phase = view.findViewById(R.id.phase)
        image.setOnClickListener { onClickTasbehLogic() }

    }

    fun onClickTasbehLogic(){

        counter++
        counterXml.text = "$counter"

        if (phase.text == Constants.khatema){

            phase.text = Constants.subhan_allah
            counter = 0
            counterXml.text = "$counter"


            Toast.makeText(activity?.applicationContext, "لقد انهيت التسبيح", Toast.LENGTH_LONG).show()


        }


        if ( counter == 33){
            if(phase.text == Constants.subhan_allah) {

                phase.text = Constants.alhamdulillah
                counter = 0
                counterXml.text = "$counter"
                }


            else if (phase.text == Constants.alhamdulillah){
                phase.text = Constants.allahu_akbar
                counter = 0
                counterXml.text = "$counter"

                }
            else if (phase.text == Constants.allahu_akbar){
                phase.text = Constants.khatema
                counter = 0
                counterXml.text = "$counter"



            }

        }


        }




    }
