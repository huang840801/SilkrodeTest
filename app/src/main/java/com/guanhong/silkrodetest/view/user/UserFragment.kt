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
import org.koin.android.ext.android.get

class UserFragment : Fragment(), UserAdapter.UserAdapterListener {

    private val viewModel: UserViewModel = get()

    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    private val perPage = 10
    private var fromId = 0

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

        viewModel.userList.observe(viewLifecycleOwner, { userList ->

            adapter.setUserList(userList)
        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!recyclerView.canScrollVertically(1)) {

                    fromId += perPage
                    viewModel.getUserList(perPage, fromId)
                }
            }
        })

        viewModel.getUserList(perPage, fromId)
    }

    override fun itemClick(user: User) {

        val intent = UserDetailActivity.getIntent(requireContext(), user)
        startActivity(intent)
    }
}