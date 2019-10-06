package com.example.digitalturbine2.repo

import androidx.lifecycle.LiveData
import com.example.digitalturbine2.api.RetrofitClient
import com.example.digitalturbine2.model.Campaign
import com.example.digitalturbine2.model.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

    fun getData(): LiveData<List<Campaign>> {
        return object : LiveData<List<Campaign>>() {
            override fun onActive() {
                super.onActive()
                if (value == null || value?.isEmpty()!!) {
                    RetrofitClient.instance.getDetails()
                        .enqueue(object : Callback<DefaultResponse> {
                            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                                value = null
                            }

                            override fun onResponse(
                                call: Call<DefaultResponse>,
                                response: Response<DefaultResponse>
                            ) {
                                value = response.body()?.campaigns as List<Campaign>?
                            }
                        })

                }
            }
        }
    }

}