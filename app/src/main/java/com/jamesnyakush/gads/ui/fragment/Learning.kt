package com.jamesnyakush.gads.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.response.LearningResponse
import com.jamesnyakush.gads.data.network.ApiService
import com.jamesnyakush.gads.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Learning : Fragment(R.layout.learning_fragment) {
    private val herokuapp by lazy { ApiService.invoke(Constants.HEROKU_URL) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchLearingLeaders()
    }

    private fun fetchLearingLeaders() {
        var call = herokuapp.getLeaders()

        call.enqueue(object : Callback<LearningResponse> {
            override fun onFailure(call: Call<LearningResponse>, t: Throwable) {
                Log.d("Learning", t.message.toString())
            }

            override fun onResponse(
                call: Call<LearningResponse>,
                response: Response<LearningResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        response.body().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        })
    }
}