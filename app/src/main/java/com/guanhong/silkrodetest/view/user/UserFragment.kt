package com.guanhong.silkrodetest.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User
import com.guanhong.silkrodetest.view.UserDetailActivity

class UserFragment : Fragment(), UserAdapter.UserAdapterListener {

    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserAdapter(this)
        recyclerView.adapter = adapter
    }

    fun setUserList(userList: List<User>) {

        adapter.setUserList(userList)
    }

    override fun itemClick(user: User) {

        val intent = UserDetailActivity.getIntent(requireContext(), user)
        startActivity(intent)
    }
}