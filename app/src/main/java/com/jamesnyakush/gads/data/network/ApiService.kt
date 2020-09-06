package com.jamesnyakush.gads.data.network

import com.jamesnyakush.gads.data.model.response.LearningResponse
import com.jamesnyakush.gads.data.model.response.SkillIQResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


const val HEROKU_URL: String = "https://gadsapi.herokuapp.com/"
const val GOOGLE_FORM_URL: String = "https://gadsapi.herokuapp.com/"

interface ApiService {


    @GET("api/hours")
    fun getLeaders(): Call<LearningResponse>

    @GET("api/skilliq")
    fun getSkilliq(): Call<SkillIQResponse>

    companion object {
        // init Retrofit base server instance



        val herokuapp by lazy { ApiService.invoke(HEROKU_URL) }
        val googleform by lazy { ApiService.invoke(GOOGLE_FORM_URL) }

        //private val loggingInterceptor = HttpLoggingInterceptor().apply {
        //    this.level = HttpLoggingInterceptor.Level.BODY
        //}

        operator fun invoke(baseUrl: String): ApiService {
            //val client = OkHttpClient.Builder().apply {
            //    /**addNetworkInterceptor(StethoInterceptor()) */
            //    addNetworkInterceptor(loggingInterceptor)
            //    connectTimeout(10, TimeUnit.MINUTES)
            //    readTimeout(10, TimeUnit.MINUTES)
            //    writeTimeout(10, TimeUnit.MINUTES)
            // }.build()

            return Retrofit.Builder()
                //.client(client)
                .baseUrl(baseUrl)
                //.addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

}