package com.jamesnyakush.gads.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.data.model.SkillIQ
import kotlinx.android.synthetic.main.item_skill.view.*

class SkillIQAdapter(
    var skills: List<SkillIQ>
) : RecyclerView.Adapter<SkillIQAdapter.SkillIQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SkillIQViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
    )

    override fun getItemCount() = skills.size

    override fun onBindViewHolder(holder: SkillIQViewHolder, position: Int) {
        var skill = skills[position]

        //holder.itemView.learning_image_url.drawable = learning.badgeUrl
        holder.itemView.skill_name.text = skill.name
        holder.itemView.skill_score.text = skill.score
        holder.itemView.skill_country.text = skill.country
    }

    inner class SkillIQViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}