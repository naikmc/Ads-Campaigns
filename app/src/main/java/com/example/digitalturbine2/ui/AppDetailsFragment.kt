package com.example.digitalturbine2.ui

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.digitalturbine2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.app_details_fragment.*

class AppDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = AppDetailsFragment()
    }

    private lateinit var viewModel: AppListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(AppListViewModel::class.java)
        }!!

        viewModel.getNoDataLiveData().observe(viewLifecycleOwner, Observer {

            if(it){
                no_value.visibility = View.VISIBLE
                main_layout.visibility = View.GONE
            } else{
                no_value.visibility = View.GONE
                main_layout.visibility = View.VISIBLE
            }
        })

        viewModel.getSelectedCampaign().observe(viewLifecycleOwner, Observer { campaign->
            product_title.text =campaign.productName
            Picasso.get()
                .load(campaign.productThumbnail)
                .into(product_icon)

            Picasso.get()
                .load(campaign.averageRatingImageURL?.replace("https","http"))
                .into(review_image)
            review_text.text = "${campaign.numberOfRatings} ratings"
            no_of_downloads.text = campaign.numberOfDownloads

            install_btn.apply {
                text = campaign.callToAction
                setOnClickListener() {
                    activity?.let { activity ->
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(campaign.clickProxyURL);
                        activity.startActivity(intent)
                    }
                }
            }
            description_text.text = campaign.productDescription
            categoryName.text = campaign.categoryName

        })
    }

}
