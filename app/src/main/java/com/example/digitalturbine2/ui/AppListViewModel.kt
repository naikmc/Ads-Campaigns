package com.example.digitalturbine2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digitalturbine2.api.RetrofitClient
import com.example.digitalturbine2.model.Campaign
import com.example.digitalturbine2.model.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppListViewModel : ViewModel() {

    private val campaignListLive: MutableLiveData<List<Campaign>> = MutableLiveData()
    private val campaignLive: MutableLiveData<Campaign> = MutableLiveData()
    private val noDataLiveData : MutableLiveData<Boolean> = MutableLiveData()

    init {
        getData()
    }

    fun getCampaignListLiveData(): LiveData<List<Campaign>> {
        return campaignListLive
    }

    private fun getData() {

        RetrofitClient.instance.getDetails().enqueue(object : Callback<DefaultResponse> {
            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<DefaultResponse>,
                response: Response<DefaultResponse>
            ) {
                campaignListLive.value = response.body()?.campaigns as List<Campaign>?
            }
        })
    }

    fun setSelectedCampaign(campaign: Campaign?) {
        if(campaign != null) {
            campaignLive.value = campaign
            noDataLiveData.value = false;
        } else{
            noDataLiveData.value = true
        }

    }

    fun getNoDataLiveData(): LiveData<Boolean>{
        return noDataLiveData
    }

    fun getSelectedCampaign(): LiveData<Campaign> {
        return campaignLive;
    }

}
