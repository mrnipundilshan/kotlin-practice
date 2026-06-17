package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.drawable.ic_calender,
            R.drawable.ic_cart,
            R.drawable.ic_home,
            R.drawable.ic_location,
            R.drawable.ic_maps,
            R.drawable.ic_notes,
            R.drawable.ic_paint,
            R.drawable.ic_people,
            R.drawable.ic_bell
        )

        titleList = arrayOf(
            "Calender",
            "Cart",
            "Home" ,
            "Location",
            "Maps",
            "Notes",
            "Paint",
            "People",
            "Bell"
        )

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()

    }

    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }
}