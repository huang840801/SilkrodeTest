package com.guanhong.silkrodetest.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User
import com.guanhong.silkrodetest.view.user.UserFragment

class MainActivity : AppCompatActivity(), UserFragment.UserFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userFragment = UserFragment()
        val infoFragment = MineFragment()
        userFragment.setListener(this)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {

            override fun getCount() = 2
            override fun getItem(position: Int): Fragment {

                return when (position) {
                    0 -> userFragment
                    1 -> infoFragment
                    else -> throw Exception()
                }
            }
        }

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageSelected(position: Int) {

                when (position) {
                    0 -> bottomNavigation.selectedItemId = R.id.icon_user
                    1 -> bottomNavigation.selectedItemId = R.id.icon_info
                }
            }
        })

        bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.icon_user -> viewPager.currentItem = 0
                R.id.icon_info -> viewPager.currentItem = 1
            }

            true
        }
    }

    override fun itemClick(user: User, imageView: ImageView, name: TextView) {

        val intent = UserDetailActivity.getIntent(this, user)
        val option = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
            androidx.core.util.Pair.create(imageView, "my_image"),
            androidx.core.util.Pair.create(name, "my_name")
        )
        startActivity(intent, option.toBundle())
    }
}