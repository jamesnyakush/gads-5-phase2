package com.jamesnyakush.gads.data.network

import com.jamesnyakush.gads.data.model.Learning
import com.jamesnyakush.gads.data.model.SkillIQ
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("api/hours")
    fun getLeaders(): Call<Learning>

    @GET("api/skilliq")
    fun getSkilliq(): Call<SkillIQ>

    @POST("")
    @FormUrlEncoded
    fun submit(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") LinkToProject: String
    ): Call<Void>
}