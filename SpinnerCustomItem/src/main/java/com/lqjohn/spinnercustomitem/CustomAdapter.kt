package com.lqjohn.spinnercustomitem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val mContext: Context, val mData: ArrayList<UserModel>) : BaseAdapter() {
    private val mInflate: LayoutInflater

    init {
        mInflate = LayoutInflater.from(mContext)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder
        var view = convertView

        if (view == null) {
            view = mInflate.inflate(R.layout.view_custom_item, parent, false)
            viewHolder = ViewHolder(view)
        } else {
            viewHolder = view.tag as ViewHolder
        }

        view?.tag = viewHolder

        viewHolder.tvUsername.text = mData[position].name

        return view!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: DropdownViewHolder
        var view = convertView

        if (view == null) {
            view = mInflate.inflate(R.layout.view_custom_drop_down_item, parent, false)
            viewHolder = DropdownViewHolder(view)
        } else {
            viewHolder = view.tag as DropdownViewHolder
        }

        view?.tag = viewHolder

        viewHolder.tvUsername.text = mData[position].name

        return view!!
    }

    override fun getItem(position: Int): Any = mData[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mData.size

    class ViewHolder(view: View){
        lateinit var tvUsername: TextView

        init {
            tvUsername = view.findViewById(R.id.tvUserName)
        }
    }

    class DropdownViewHolder(view: View){
        lateinit var tvUsername: TextView
        lateinit var ivAvatar: ImageView

        init {
            tvUsername = view.findViewById(R.id.tvUserName)
            ivAvatar = view.findViewById(R.id.ivAvatar)
        }
    }
}