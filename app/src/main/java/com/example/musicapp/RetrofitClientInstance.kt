package com.example.musicapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null;
    private const val BASE_URL = "https://jsonkeeper.com"
    val retrofitInstance: Retrofit?
        get() {
            // has this object been created yet?
            if (retrofit == null) {
                // create it!
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                print("foo")
            }
            return retrofit
        }
}