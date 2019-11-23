package com.loopserv.durhack.ui.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.statusBarColor = Color.parseColor("#fafafa")

        if(FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        login_username.requestFocus()

        login_login.setOnClickListener {
            val txt = login_username.text.toString()
            val pass = login_password.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(txt, pass)
                .addOnSuccessListener {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Unable to login", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
