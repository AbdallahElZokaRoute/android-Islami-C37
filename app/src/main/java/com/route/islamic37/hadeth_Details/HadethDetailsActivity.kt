package com.route.islamic37.hadeth_Details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.route.islamic37.Constants
import com.route.islamic37.R

class HadethDetailsActivity : AppCompatActivity() {


    var hadethPosition : Int = 0
    lateinit var body : TextView
    lateinit var header : TextView
    lateinit var imageButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        var hadeth = intent.getStringArrayListExtra(Constants.content_intent) as List<String>
        hadethPosition = intent.getIntExtra(Constants.position_intent, 5)
        body = findViewById(R.id.hadethDetails)
        header = findViewById(R.id.header)
        header.text = ContentSpliter(hadeth)[0]
        body.text = ContentSpliter(hadeth)[1]
        imageButton = findViewById(R.id.back_button)

        imageButton.setOnClickListener { finish() }

    }


    fun ContentSpliter(Content: List<String>) : Array<String>{
            var arrContent = Array<String>(2){""}
        var content = Content.elementAt(hadethPosition).split('\n') as MutableList

        if(hadethPosition ==0)
        {
            arrContent[0] = content.elementAt(0)
            content.removeAt(0)
            arrContent[1] = content.toString()
            return arrContent
        }
        else{
            arrContent[0] = content.elementAt(1)
            content.removeAt(1)
            arrContent[1] = content.toString()
            return arrContent

        }

    }


}


/*
    I intended to use these 2 function to split the content of the ahadeth activity but I've decided that I wanted to let one
    function do the job by storing both the header and the content in a single array with the size of 2.


fun headerGenerator(Content : List<String>): String {
        var header = Content.elementAt(hadethPosition).split('\n')

        if(hadethPosition ==0)
        {
        return header.elementAt(0)
        }

        return header.elementAt(1)
    }

    fun contentGenerator(Content:List<String>): String {

        var content = Content.elementAt(hadethPosition).split('\n') as MutableList

        if(hadethPosition == 0) {
            content.removeAt(0)
        }
        else{
            content.removeAt(1)
        }
        return content.toString()
    }


 */