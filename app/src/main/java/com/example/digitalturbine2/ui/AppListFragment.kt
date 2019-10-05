package com.example.digitalturbine2.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.digitalturbine2.R
import com.example.digitalturbine2.adapter.CampaignListener
import com.example.digitalturbine2.adapter.MyAdapter
import kotlinx.android.synthetic.main.app_list_fragment.*

class AppListFragment : Fragment(), CampaignListener {


    companion object {
        fun newInstance() = AppListFragment()
    }

    private lateinit var viewModel: AppListViewModel

    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(AppListViewModel::class.java)
        }!!
        myAdapter  = MyAdapter( this@AppListFragment)
        recycler_view.apply {
            layoutManager = GridLayoutManager(this@AppListFragment.context,2)
            adapter = myAdapter
        }

        viewModel.getCampaignListLiveData().observe(viewLifecycleOwner, Observer {
            myAdapter.setCampaignList(it)
        })
    }

    override fun onCampaignClick(position: Int) {
        myAdapter.getCampaign(position).let {

            viewModel.setSelectedCampaign(it)

        }
        fragmentManager?.beginTransaction()?.replace(R.id.frame_layout, AppDetailsFragment.newInstance())?.addToBackStack(null)?.commit()
    }

}
