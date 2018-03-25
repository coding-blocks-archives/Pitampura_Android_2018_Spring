package com.codingblocks.jsonapinavdrawer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.codingblocks.jsonapinavdrawer.api.api
import com.codingblocks.jsonapinavdrawer.fragments.PostsFragment
import com.codingblocks.jsonapinavdrawer.fragments.UsersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navView.setNavigationItemSelectedListener(this)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.flContainer, fragment)
                .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.users -> setFragment(UsersFragment())
            R.id.posts -> setFragment(PostsFragment())
        }
        return true
    }
}
