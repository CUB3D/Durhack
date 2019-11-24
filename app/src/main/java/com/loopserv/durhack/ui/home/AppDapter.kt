package com.loopserv.durhack.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loopserv.durhack.R
import com.loopserv.durhack.ui.api.CreditApplication

class AppDapter(ctx: Context, private val applications: List<CreditApplication>) : RecyclerView.Adapter<AppDapter.viewHolder>() {
    val lm = LayoutInflater.from(ctx)

    class viewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val value = view.findViewById<TextView>(R.id.app_value)
        val state = view.findViewById<TextView>(R.id.app_state)


        fun bind(creditApplication: CreditApplication) {
            value.text = creditApplication.name.takeIf { it.isNotBlank() } ?: "Test"
            state.text = creditApplication.state
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            lm.inflate(R.layout.app_entry, parent, false)
        )
    }

    override fun getItemCount() = applications.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(applications[position])
    }
}
