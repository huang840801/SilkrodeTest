package com.guanhong.silkrodetest.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.guanhong.silkrodetest.R
import com.guanhong.silkrodetest.User

class UserDetailActivity : AppCompatActivity() {

    companion object {

        private const val USER = "USER"

        fun getIntent(context: Context, user: User): Intent {

            return Intent(context, UserDetailActivity::class.java).apply {

                putExtra(USER, user)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        supportActionBar?.hide()

        val close = findViewById<ImageView>(R.id.close)
        val name = findViewById<TextView>(R.id.name)
        val smallName = findViewById<TextView>(R.id.smallName)
        val id = findViewById<TextView>(R.id.id)
        val webLink = findViewById<TextView>(R.id.webLink)

        val user = intent.getParcelableExtra<User>(USER)

        user?.let {

            name.text = it.name
            smallName.text = it.name
            id.text = it.id
            webLink.text = it.webLink
        }

        close.setOnClickListener { finish() }
    }
}