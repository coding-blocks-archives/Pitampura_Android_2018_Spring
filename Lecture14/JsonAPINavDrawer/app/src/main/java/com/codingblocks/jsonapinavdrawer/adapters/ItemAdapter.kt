package com.codingblocks.jsonapinavdrawer.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ItemAdapter<I>(
        val itemList: ArrayList<I>,
//        val itemLayoutId: Int,
        val createItemView: () -> View,
        val bindView: (itemView: View, item: I) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    interface ItemBindViewHandler {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = createItemView()
        return ItemViewHolder(view)

    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.d("BVH", "pos = $position")
        bindView(holder.itemView, itemList[position])
    }

    class ItemViewHolder(iv: View): RecyclerView.ViewHolder(iv)

}