package com.guanhong.silkrodetest.view.user

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User

class UserAdapter(private val listener: UserAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    UserHolder.UserHolderListener {

    private var isLoading = false
    private var userList: List<User> = listOf()

    private val normalType = 1
    private val loadingType = 2

    interface UserAdapterListener {

        fun itemClick(user: User, imageView: ImageView, name: TextView)
    }

    override fun itemClick(user: User, imageView: ImageView, name: TextView) {

        listener.itemClick(user, imageView, name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {

            normalType -> UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_user, parent, false), this, parent.context)
            loadingType -> LoadingHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_all_loading, parent, false))
            else -> throw Exception()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is UserHolder) {

            holder.bind(userList[position])
        }
    }

    override fun getItemCount(): Int {

        var userCount = userList.count()

        if (isLoading) userCount++

        return userCount
    }

    override fun getItemViewType(position: Int): Int {

        return if (position < userList.count()) normalType else loadingType
    }

    fun setUserList(userList: List<User>) {

        this.userList = userList
        notifyDataSetChanged()
    }

    fun setIsLoading(isLoading: Boolean) {

        this.isLoading = isLoading
    }
}