package com.loopserv.durhack.ui.home

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.StateManager
import com.loopserv.durhack.ui.api.API
import com.loopserv.durhack.ui.api.CreditApplicationRequest
import com.loopserv.durhack.ui.api.User
import kotlinx.android.synthetic.main.activity_confirm_id.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus

class Confirm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_id)
        window.statusBarColor = Color.parseColor("#fafafa")

        confirm_name.text = StateManager.applicationName
        confirm_address.text = StateManager.applicationAddress
        confirm_credits.text = StateManager.applicationAmount
        confirm_dob.text = StateManager.applicationDob
        confirm_how.text = StateManager.howYouWillUse

        confirm_loaReason.text = StateManager.reason
        confirm_howRepay.text = StateManager.payItBack
        confirm_repay.text = StateManager.minRepayment

        next_button.setOnClickListener {
            GlobalScope.launch {
                println(
                    API.client.createApplication(
                        CreditApplicationRequest(
                            FirebaseAuth.getInstance().currentUser!!.uid.toString(),
                            StateManager.applicationName,
                            StateManager.applicationAddress,
                            StateManager.applicationAmount,
                            StateManager.minRepayment,
                            StateManager.applicationDob,
                            StateManager.howYouWillUse,
                            StateManager.reason,
                            StateManager.payItBack
                        )
                    )
                )

                EventBus.getDefault().post(User(emptyList()))

                this@Confirm.runOnUiThread {
                    finish()
                }
            }
        }
    }
}
