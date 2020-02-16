package com.example.my_memo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MemoDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memo_detail)

        var memoTitle : TextView = findViewById(R.id.detailTitle)
        var memoParagraph : TextView = findViewById(R.id.detailParagraph)
        var iv : ImageView = findViewById(R.id.imageView1)

        var intent : Intent = getIntent()
        memoTitle.setText(intent.getStringExtra("title"))
        memoParagraph.setText(intent.getStringExtra("paragraph"))
        iv.setImageResource(intent.getIntExtra("img",0))
    }
}
