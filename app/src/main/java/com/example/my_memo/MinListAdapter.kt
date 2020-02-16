package com.example.my_memo

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MinListAdapter(val context: Context, val memos: ArrayList<Users>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.memolist,null)
       // val image = view.findViewById<TextView>(R.id.somenail)
        val title = view.findViewById<TextView>(R.id.titles)
        val paragraph = view.findViewById<TextView>(R.id.paragraph)

        val memo = memos[position]
        val resourceId = context.resources.getIdentifier(memo.title,"drawable",context.packageName)
        title.text = memo.title
        paragraph.text = memo.paragraph

        return view
    }

    override fun getItem(position: Int): Any {
        return memos[position]
    }

    override fun getItemId(position: Int): Long {
      return 0
    }

    override fun getCount(): Int {
        return memos.size
    }

    fun add(user : Users) : Boolean{
        memos.add(user)
        return true
    }

}