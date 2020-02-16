package com.example.my_memo

import android.util.Log
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context) : SQLiteOpenHelper(context,DB_NAME, null,DB_VERSION){

    companion object{
        private val DB_NAME = "MemoDB"
        private val DB_VERSION = 1
        private val TABLE_NAME = "users"
        private val ID  = "id"
        private val TITLE = "Title"
        private val PARAGRAPH= "paragraph"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME" +
        "($ID Integer," + "$TITLE TEXT," + "$PARAGRAPH TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
        fun addUser(user: Users) : Boolean {
            val db = this.writableDatabase
            val values = ContentValues()
            values.put(ID,user.id)
            values.put(TITLE, user.title)
            values.put(PARAGRAPH,user.paragraph)
            val _success = db.insert(TABLE_NAME, null, values)
            db.close()
            return (Integer.parseInt("$_success")!=-1)
        }

        fun getAllUser() : ArrayList<Users>{
            var memoList = arrayListOf<Users>()

            val db = readableDatabase
            val selectALLQuery = "SELECT * FROM $TABLE_NAME"
            val cursor = db.rawQuery(selectALLQuery,null)
            var user : Users
            if(cursor!=null){
                if(cursor.moveToFirst()){
                    do{
                       // Log.d(TAG,"조회 firstName : " +  Integer.parseInt(cursor.getString(cursor.getColumnIndex(TITLE))))

                        user = Users()
                        user.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                        user.title=cursor.getString(cursor.getColumnIndex(TITLE))
                        user.paragraph=cursor.getString(cursor.getColumnIndex(PARAGRAPH))

                        memoList.add(user)
                    }while(cursor.moveToNext())
                }
            }
            cursor.close()
            db.close()


            return memoList
        }
    }