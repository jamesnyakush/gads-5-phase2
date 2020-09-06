package com.jamesnyakush.gads.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.jamesnyakush.gads.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        logo!!.startAnimation(myanim)


        i = Intent(this, Leaderboard::class.java)


        val timer = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(i)
                    finish()
                }
            }
        }
        timer.start()
    }
}