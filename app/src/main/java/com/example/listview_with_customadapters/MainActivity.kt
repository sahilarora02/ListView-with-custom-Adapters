package com.example.listview_with_customadapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name  = arrayOf("Tom" , "Jack" , "Sahil" , "yash" , "John")

        val lastMsg = arrayOf("hey bro" , "wassup" , "All good?" , "Meet you there" , "Its Punisher bro..")

        val lastMsgTime = arrayOf("6:25 AM" , "7:30 PM" , "5:40 PM" , "11:00 AM" , "1:00 AM")

        val phoneNumber = arrayOf("9898748451" , "1887581845" , "9889181121" , "9908425815", "8181818751")

        val imgId = intArrayOf(R.drawable.img2 , R.drawable.img1 , R.drawable.img3 , R.drawable.img4 , R.drawable.img5)

       userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(name[eachIndex] , lastMsg[eachIndex] , lastMsgTime[eachIndex] , phoneNumber[eachIndex]
            , imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView  = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this , userArrayList)

    ////        listView.setOnItemClickListener { adapterView, view, i, l ->
    //            val userName = name[i]
    //            val userPhone = phoneNumber[i]
    //            val imgId = imgId[i]
    //
    //            val i = Intent(this , UserActivity::class.java)
    //
    //            i.putExtra("name" , userName)
    //            i.putExtra("phone" , userPhone)
    //            i.putExtra("imageId" , imgId)
    //            startActivity(i )
    ////        }
        listView.setOnItemClickListener{parent , view , position , id ->
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this , UserActivity::class.java)

            i.putExtra("name" , userName)
            i.putExtra("phone" , userPhone)
            i.putExtra("imageId" , imageId)
            startActivity(i)
        }
    }
}