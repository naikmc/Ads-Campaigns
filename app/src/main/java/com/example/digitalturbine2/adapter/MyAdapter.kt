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

class MyAdapter(var campaignList: List<Campaign>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.campaign_item,parent, false))
    }

    override fun getItemCount(): Int {
        return campaignList?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        campaignList?.get(position)?.let { ( holder as MyViewHolder).bind(it) }

    }


    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var title : TextView = view.findViewById(R.id.textView)
        var image : ImageView = view.findViewById(R.id.imageView)
        var ratingImage : ImageView = view.findViewById(R.id.rating_image)
        var ratingText : TextView = view.findViewById(R.id.rating_text)

        fun bind(campaign: Campaign){
            title.text = campaign.productName
            ratingText.text = campaign.rating.toString()
            Picasso.get()
                .load(campaign.averageRatingImageURL?.replace("https","http"))
                //.fit()
                .into(ratingImage)
            Picasso.get()
                .load(campaign.productThumbnail)
                //.fit()
                .into(image)


        }


    }

}