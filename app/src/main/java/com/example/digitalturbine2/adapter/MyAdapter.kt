package com.example.digitalturbine2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalturbine2.R
import com.example.digitalturbine2.model.Campaign
import com.squareup.picasso.Picasso

class MyAdapter(val campaignListener :CampaignListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

private var campaignList: List<Campaign> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.campaign_item,parent, false),campaignListener )
    }

    override fun getItemCount(): Int {
        return campaignList?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        campaignList?.get(position)?.let { ( holder as MyViewHolder).bind(it) }

    }


    class MyViewHolder(val view: View, private val campaignListener :CampaignListener) : RecyclerView.ViewHolder(view) , View.OnClickListener{
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            campaignListener.onCampaignClick(adapterPosition)
        }

        var title : TextView = view.findViewById(R.id.textView)
        var image : ImageView = view.findViewById(R.id.imageView)
        var ratingImage : ImageView = view.findViewById(R.id.rating_image)
        var ratingText : TextView = view.findViewById(R.id.rating_text)



        fun bind(campaign: Campaign){
            title.text = campaign.productName
            ratingText.text = campaign.rating.toString()
            Picasso.get()
                .load(campaign.averageRatingImageURL?.replace("https","http"))
                .into(ratingImage)
            Picasso.get()
                .load(campaign.productThumbnail)
                .into(image)
        }
    }

    fun setCampaignList(list: List<Campaign>){
        campaignList = list  as ArrayList<Campaign>
        notifyDataSetChanged()
    }

    fun getCampaign(position: Int): Campaign? {
        if (campaignList != null && campaignList!!.size > 0) {
            return campaignList!![position]
        }
        return null

    }

}