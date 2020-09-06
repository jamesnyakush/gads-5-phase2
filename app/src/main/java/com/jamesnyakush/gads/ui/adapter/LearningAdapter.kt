package com.jamesnyakush.gads.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.Learning
import com.jamesnyakush.gads.data.model.response.LearningResponse
import kotlinx.android.synthetic.main.item_learning.view.*

class LearningAdapter(
    var learnings: ArrayList<Learning>
) : RecyclerView.Adapter<LearningAdapter.LearningViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LearningViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_learning, parent, false)
    )

    override fun getItemCount() = learnings.size

    override fun onBindViewHolder(holder: LearningViewHolder, position: Int) {
        var learning = learnings[position]

        //holder.itemView.learning_image_url.drawable = learning.badgeUrl
        holder.itemView.learning_name.text = learning.name
        holder.itemView.learning_hours.text = learning.hours
        holder.itemView.learning_country.text = learning.country
    }

    inner class LearningViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}