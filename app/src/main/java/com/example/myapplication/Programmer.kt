package com.example.myapplication

class Programmer(var name:String, var age: Int,var languages:Array<Language>, var friends: Array<Programmer>? = null) {

    enum class Language{
        C,
        Kotlin,
        Java,
        Python
    }

    fun code(){
        for (language: Language in languages){
            println("Yo $name ,estoy programando en $language")
        }
    }
}