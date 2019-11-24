package com.loopserv.durhack.ui.home

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.api.API
import com.loopserv.durhack.ui.api.FirebaseDto
import com.loopserv.durhack.ui.api.User
import com.loopserv.durhack.ui.applydetails.ApplyActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R
                .layout.activity_home
        )
        home_apply.setOnClickListener { startActivity(Intent(this, ApplyActivity::class.java)) }
        window.statusBarColor = Color.parseColor("#fafafa")

        EventBus.getDefault().register(this)

        GlobalScope.launch {
            API.client.getUser(FirebaseDto(FirebaseAuth.getInstance().currentUser!!.uid))?.let {
                println("Got user: $it")

                this@HomeActivity.runOnUiThread {
                    home_apps.adapter = AppDapter(this@HomeActivity, it.applications)
                    home_apps.layoutManager = LinearLayoutManager(this@HomeActivity)
                }
            }

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewApplication(user: User) {
        GlobalScope.launch {
            API.client.getUser(FirebaseDto(FirebaseAuth.getInstance().currentUser!!.uid))?.let {
                println("Got user: $it")
                this@HomeActivity.runOnUiThread {
                    home_apps.adapter = AppDapter(this@HomeActivity, it.applications)
                    home_apps.layoutManager = LinearLayoutManager(this@HomeActivity)
                }
            }

        }
    }

    override fun onDestroy() {
        EventBus.getDefault().register(this)
        super.onDestroy()
    }
}
