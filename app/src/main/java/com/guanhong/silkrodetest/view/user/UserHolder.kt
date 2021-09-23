package com.guanhong.silkrodetest.view.user

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User

class UserHolder(
    itemView: View,
    private val listener: UserHolderListener,
    private val context: Context
) : RecyclerView.ViewHolder(itemView) {

    interface UserHolderListener {

        fun itemClick(user: User)
    }

    fun bind(user: User) {

        Glide.with(context)
            .load(user.avatarUrl)
            .circleCrop()
            .into(itemView.findViewById(R.id.imageView))

        itemView.findViewById<TextView>(R.id.name).text = user.name
        itemView.setOnClickListener {

            listener.itemClick(user)
        }
    }
}