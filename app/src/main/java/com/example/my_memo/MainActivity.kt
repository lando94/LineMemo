package com.example.my_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dbHandler : DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHelper(this)


        button.setOnClickListener{
            if(validation()){
                val users: Users = Users()
                var success : Boolean = false
                users.firstName = editText.text.toString()
                users.lastName = editText2.text.toString()

                success = dbHandler!!.addUser(users)

                if(success){
                    val toast = Toast.makeText(this,
                        "Save Successfully",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
        button2.setOnClickListener{
            var users = dbHandler!!.getAllUser()
            textView.setText(users)
        }
    }
    fun validation() : Boolean{
        var validate : Boolean = false

        if(!editText.text.isEmpty() && !editText2.text.isEmpty()){
            validate = true
        }else{
            validate = false
            val toast = Toast.makeText(this, "fill all details", Toast.LENGTH_SHORT).show()
        }
        return validate
    }
}
