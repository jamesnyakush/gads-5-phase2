package com.jamesnyakush.gads.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jamesnyakush.gads.R
import com.jamesnyakush.gads.ui.fragment.Learning
import com.jamesnyakush.gads.ui.fragment.SkillIQ
import com.jamesnyakush.gads.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.leaderboard_activity.*


class Leaderboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar!!.hide()
        setContentView(R.layout.leaderboard_activity)

        setup()
    }

    private fun setup() {
        val adapter = ViewPagerAdapter(
            supportFragmentManager
        )
        adapter.addFragment(Learning(), "Learning Leaders")
        adapter.addFragment(SkillIQ(), "Skill IQ Leaders")

        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
    }
}