package com.example.digitalturbine2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digitalturbine2.model.Campaign
import com.example.digitalturbine2.repo.Repository

class AppListViewModel : ViewModel() {

    private val campaignLive: MutableLiveData<Campaign> = MutableLiveData()
    private var campaignListLive: LiveData<List<Campaign>>
    private val noDataLiveData : MutableLiveData<Boolean> = MutableLiveData()

    init {
            campaignListLive = Repository.getData()

    }

    fun getCampaignListLiveData(): LiveData<List<Campaign>> {
        return campaignListLive
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
