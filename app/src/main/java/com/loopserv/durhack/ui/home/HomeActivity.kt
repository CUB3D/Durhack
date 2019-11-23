package com.loopserv.durhack.ui.home

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.api.API
import com.loopserv.durhack.ui.api.FirebaseDto
import com.loopserv.durhack.ui.applydetails.ApplyActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R
                .layout.activity_home
        )
        home_apply.setOnClickListener { startActivity(Intent(this, ApplyActivity::class.java)) }
        window.statusBarColor = Color.parseColor("#fafafa")

        FirebaseAuth.getInstance().currentUser!!.getIdToken(false).addOnSuccessListener {
            GlobalScope.launch {
                println(API.client.getUser(FirebaseDto(it.token!!)))
            }
        }
    }
}
