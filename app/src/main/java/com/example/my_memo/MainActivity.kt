package com.example.my_memo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.memolist.view.*


class MainActivity : AppCompatActivity() {

    var dbHandler : DatabaseHelper? = null
    var memoList = arrayListOf<Users>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHelper(this)
        var memoadapter = MinListAdapter(this,memoList)
        memolist.adapter = memoadapter

        button.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener{
            var users = dbHandler!!.getAllUser()
            Log.d("dd","size1:" +users.size + "  size2 : " + memoadapter.count )

            if(users.size != memoadapter.count){
                var s = users.size
                var t = memoadapter.count
                while(s-t>0) {
                    memoadapter.add(users.get(s - 1))
                    s--
                }
            }
            memoadapter.notifyDataSetChanged()
        }

        /*memolist.setOnItemClickListener { parent, view, position, id ->

        }*/




    }


}
