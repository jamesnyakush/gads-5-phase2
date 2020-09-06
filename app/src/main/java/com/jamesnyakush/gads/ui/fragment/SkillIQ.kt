package com.jamesnyakush.gads.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.response.SkillIQResponse
import com.jamesnyakush.gads.data.network.ApiService
import com.jamesnyakush.gads.data.network.HEROKU_URL
import com.jamesnyakush.gads.data.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkillIQ : Fragment(R.layout.skilliq_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchSkillIQLeaders()
    }

    private fun fetchSkillIQLeaders() {
//        var call = RetrofitBuilder.apiService.getSkilliq()
        var call =  ApiService.invoke(HEROKU_URL).getSkilliq()


        call.enqueue(object : Callback<SkillIQResponse> {
            override fun onFailure(call: Call<SkillIQResponse>, t: Throwable) {
                Log.d("SkillIQ", t.message.toString())
            }

            override fun onResponse(
                call: Call<SkillIQResponse>,
                response: Response<SkillIQResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), response.body().toString(), Toast.LENGTH_SHORT)
                        .show()

                    Log.d("SkillIQ", response.body().toString())
                }
            }

        })



    }

}