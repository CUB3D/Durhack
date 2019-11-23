package com.loopserv.durhack.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.applydetails.ApplyActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R
            .layout.activity_home)
        home_apply.setOnClickListener { startActivity(Intent(this, ApplyActivity :: class.java)) }
        window.statusBarColor = Color.parseColor("#fafafa")

    }
}
