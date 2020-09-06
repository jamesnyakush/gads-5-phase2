package com.jamesnyakush.gads.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.response.SkillIQResponse
import com.jamesnyakush.gads.data.network.ApiService
import com.jamesnyakush.gads.ui.adapter.SkillIQAdapter
import com.jamesnyakush.gads.utils.Constants.HEROKU_URL
import kotlinx.android.synthetic.main.skilliq_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkillIQ : Fragment(R.layout.skilliq_fragment) {

    private val herokuapp by lazy { ApiService.invoke(HEROKU_URL) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchSkillIQLeaders()
    }


    private fun fetchSkillIQLeaders() {
        var call = herokuapp.getSkilliq()

        call.enqueue(object : Callback<SkillIQResponse> {
            override fun onFailure(call: Call<SkillIQResponse>, t: Throwable) {
                Log.d("SkillIQ", t.message.toString())
            }

            override fun onResponse(
                call: Call<SkillIQResponse>,
                response: Response<SkillIQResponse>
            ) {
                if (response.isSuccessful) {
                    recycler_skill.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        hasFixedSize()
                        adapter = SkillIQAdapter(response.body()!!)
                    }
                } else {
                    Log.d("SkillIQ", response.errorBody().toString())
                }
            }
        })
    }

}