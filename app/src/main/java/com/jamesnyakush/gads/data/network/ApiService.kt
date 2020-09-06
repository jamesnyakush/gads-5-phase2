package com.jamesnyakush.gads.data.network

import com.jamesnyakush.gads.data.model.response.LearningResponse
import com.jamesnyakush.gads.data.model.response.SkillIQResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface ApiService {

    @GET("api/hours")
    fun getLeaders(): Call<LearningResponse>

    @GET("api/skilliq")
    fun getSkilliq(): Call<SkillIQResponse>

    @POST("")
    @FormUrlEncoded
    fun submit(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") LinkToProject: String
    ): Call<Void>

    companion object {


//        private val loggingInterceptor = HttpLoggingInterceptor().apply {
//            this.level = HttpLoggingInterceptor.Level.BODY
//        }

        operator fun invoke(baseUrl: String): ApiService {
//            val client = OkHttpClient.Builder().apply {
//                /**addNetworkInterceptor(StethoInterceptor()) */
//                addNetworkInterceptor(loggingInterceptor)
//                connectTimeout(10, TimeUnit.MINUTES)
//                readTimeout(10, TimeUnit.MINUTES)
//                writeTimeout(10, TimeUnit.MINUTES)
//             }.build()

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