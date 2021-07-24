package com.guanhong.silkrodetest.view.user

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User

class UserHolder(
    itemView: View,
    private val listener: UserHolderListener
) : RecyclerView.ViewHolder(itemView) {

    interface UserHolderListener {

        fun itemClick(user: User)
    }

    fun bind(user: User) {

        itemView.findViewById<TextView>(R.id.name).text = user.name
        itemView.setOnClickListener {

            listener.itemClick(user)
        }
    }
}