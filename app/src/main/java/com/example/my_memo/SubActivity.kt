package com.example.my_memo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    var dbHandler : DatabaseHelper? = null
    var memoList = arrayListOf<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        dbHandler = DatabaseHelper(this)
        var memoadapter = MinListAdapter(this,memoList)
        //memolist.adapter = memoadapter


        add.setOnClickListener{  //새 메모 작성
            if(validation()){
                val users: Users = Users()
                var success : Boolean = false
                users.title = titleCreateEditer.text.toString()
                users.paragraph = paragraphCreateEditer.text.toString()
                users.id = 1
                success = dbHandler!!.addUser(users)

                if(success){
                    val toast = Toast.makeText(this,
                        "Save Successfully",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    val toast = Toast.makeText(this,"fail", Toast.LENGTH_SHORT).show()
                }
            }
        }

        toMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validation(): Boolean {
        var validate : Boolean = false

        if(!titleCreateEditer.text.isEmpty() && !paragraphCreateEditer.text.isEmpty()){
            validate = true
        }else{
            validate = false
            val toast = Toast.makeText(this, "fill all details", Toast.LENGTH_SHORT).show()
        }
        return validate
    }
}