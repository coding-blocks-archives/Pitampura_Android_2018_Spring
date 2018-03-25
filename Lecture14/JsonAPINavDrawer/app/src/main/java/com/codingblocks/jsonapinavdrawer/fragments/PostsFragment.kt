package com.codingblocks.jsonapinavdrawer.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.codingblocks.jsonapinavdrawer.ItemAdapter

import com.codingblocks.jsonapinavdrawer.R
import com.codingblocks.jsonapinavdrawer.api.api
import com.codingblocks.jsonapinavdrawer.models.Post
import com.codingblocks.jsonapinavdrawer.models.User
import kotlinx.android.synthetic.main.fragment_posts.*
import kotlinx.android.synthetic.main.fragment_posts.view.*
import kotlinx.android.synthetic.main.list_item_post.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 *
 */
class PostsFragment : Fragment() {
    val posts = ArrayList<Post>()
    val postsAdapter = ItemAdapter<Post>(posts, R.layout.list_item_post) { iv, i -> iv.apply { with(i) {
        tvTitle.text = title
        tvBody.text = body
    } } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        api.jp.getPosts().enqueue(object: Callback<ArrayList<Post>> {
            override fun onFailure(call: Call<ArrayList<Post>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ArrayList<Post>>?, response: Response<ArrayList<Post>>?) {
                response?.body()?.let {
                    posts.clear()
                    posts.addAll(it)
                    postsAdapter.notifyDataSetChanged()
                }
            }

        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_posts, container, false)

        fragmentView.rvPosts.apply {
            layoutManager = LinearLayoutManager(this@PostsFragment.context)
            adapter = postsAdapter
        }

        return fragmentView
    }


}

