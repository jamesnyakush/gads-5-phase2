package com.jamesnyakush.gads.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.SkillIQ

class SkillIQAdapter(
    var skills: List<SkillIQ>
) : RecyclerView.Adapter<SkillIQAdapter.SkillIQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SkillIQViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
    )

    override fun getItemCount() = skills.size

    override fun onBindViewHolder(holder: SkillIQViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class SkillIQViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}