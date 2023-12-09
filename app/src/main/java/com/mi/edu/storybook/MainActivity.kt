package com.mi.edu.storybook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data=Constants.getStoryList()
        setAdapterRecyclerview(data)
    }
    private fun setAdapterRecyclerview(data:ArrayList<Story>){
        val recyclerView=findViewById<RecyclerView>(R.id.rvStoryList)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=StoryAdapter(data)
        recyclerView.adapter=adapter
        adapter.setOnClickListener(object :StoryAdapter.OnClickListener{
            override fun onClick(position: Int) {

                val intent =Intent(this@MainActivity,StoryActivity::class.java)
                intent.putExtra("position",position)
                startActivity(intent)
            }

        })
    }
}