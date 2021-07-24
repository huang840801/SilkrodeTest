package com.guanhong.silkrodetest.view.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User

class UserAdapter(private val listener: UserAdapterListener) :
    RecyclerView.Adapter<UserHolder>(),
    UserHolder.UserHolderListener {

    private var userList: List<User> = listOf()

    interface UserAdapterListener {

        fun itemClick(user: User)
    }

    override fun itemClick(user: User) {

        listener.itemClick(user)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {

        return UserHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_user, parent, false),
            this
        )
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

      holder.bind(userList[position])
    }

    override fun getItemCount() = userList.count()

    fun setUserList(userList: List<User>) {

        this.userList = userList
        notifyDataSetChanged()
    }
}