package com.example.country

data class Country (
        val name:String,
       val capital:String,
        val population:Long,
        val area:Long,
        val languages:List<Language>,
        val currencies:List<Currencies>
    )
data class Language(
    val name:String
)
data class Currencies(
    val name:String,
    val symbol:String
)