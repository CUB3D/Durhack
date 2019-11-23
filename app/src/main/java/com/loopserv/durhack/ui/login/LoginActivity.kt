package com.loopserv.durhack.ui.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.statusBarColor = Color.parseColor("#fafafa")

        login_username.requestFocus()

        login_login.setOnClickListener {
            val txt = login_username.text.toString()
            val pass = login_password.text.toString()

            if(txt == "admin" && pass == "1234") {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }
}
