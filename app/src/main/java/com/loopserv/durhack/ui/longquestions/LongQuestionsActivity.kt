package com.loopserv.durhack.ui.longquestions

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.StateManager
import kotlinx.android.synthetic.main.activity_long_questions.*

class LongQuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_questions)
        window.statusBarColor = Color.parseColor("#fafafa")

        longq_next.setOnClickListener {
            StateManager.how = longq_how.text.toString()
            StateManager.next = longq_next.text.toString()
            StateManager.reason = longq_reason .text.toString()
            startActivity(Intent(this, Confirm::class.java))
        }
    }
}
