package com.example.my_memo

class Users {
    var  id : Int
    var title : String
    var paragraph : String
    constructor(id : Int, title: String,paragraph: String) {
        this.id = id
        this.title = title
        this.paragraph=paragraph
    }
    constructor(){
        id=0
        title = ""
        paragraph =""
    }

}
