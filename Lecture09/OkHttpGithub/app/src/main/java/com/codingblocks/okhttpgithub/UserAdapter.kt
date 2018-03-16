package com.codingblocks.okhttpgithub

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

/**
 * Created by harshitdwivedi on 10/03/18.
 */
class UserAdapter(val githubUsers: ArrayList<GithubUser>) : RecyclerView.Adapter<UserAdapter.MyHolder>() {

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        val githubUser = githubUsers[position]
        holder?.itemView?.userLogin?.text = githubUser.name
        holder?.itemView?.userUrl?.text = githubUser.profileUrl
        holder?.itemView?.userScore?.text = githubUser.score
        Picasso.get().load(githubUser.profilePic)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.drawable.ic_action_name)
                .into(holder?.itemView?.imageUser)
    }

    override fun getItemCount() = githubUsers.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = MyHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_row, parent, false))

    inner class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
