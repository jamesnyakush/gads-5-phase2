package com.jamesnyakush.gads.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.Learning

class LearningAdapter(
    var learnings: List<Learning>
) : RecyclerView.Adapter<LearningAdapter.LearningViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LearningViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_learning, parent, false)
    )

    override fun getItemCount() = learnings.size

    override fun onBindViewHolder(holder: LearningViewHolder, position: Int) {
        var learning = learnings[position]
    }

    inner class LearningViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}