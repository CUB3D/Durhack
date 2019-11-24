package com.loopserv.durhack.ui.applydetails

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.StateManager
import com.loopserv.durhack.ui.idprovider.IdProviderActivity
import kotlinx.android.synthetic.main.activity_apply.*

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)
        window.statusBarColor = Color.parseColor("#fafafa")

        apply_next.setOnClickListener {
            StateManager.applicationAddress = apply_address.text.toString()
            StateManager.applicationDob = apply_dob.text.toString()
            StateManager.applicationName = apply_name.text.toString()
            StateManager.minRepayment = apply_replayment.text.toString()
            StateManager.applicationAmount = circular.currentProgress.toString()
            startActivity(Intent(this, IdProviderActivity::class.java))
            finish()
        }
    }
}
