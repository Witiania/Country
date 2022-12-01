package com.example.country

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestCountriesAPI {
    @GET("name/{name}")
   suspend fun getCountrieByName(@Path("name") cityName: String): List<Country> // помечаем корутину, эта функция может работать долго...
}

var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://countriesinfo21.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCountriesAPI = retrofit.create(RestCountriesAPI::class.java)