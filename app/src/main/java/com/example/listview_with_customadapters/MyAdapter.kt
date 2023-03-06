package com.example.listview_with_customadapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val context : Activity, private val arraylist : ArrayList<User>) :
    ArrayAdapter<User>(context , R.layout.eachrow , arraylist ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.eachrow , null)
        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tvName)
        val lastMsg = view.findViewById<TextView>(R.id.tvLastMsg)
        val lastMsgTime = view.findViewById<TextView>(R.id.tvLastMsgTime)

        name.text = arraylist[position].name
        lastMsg.text = arraylist[position].lastMsg
        lastMsgTime.text = arraylist[position].lastMsgTime
        image.setImageResource(arraylist[position].imageId)

        return view
    }
}