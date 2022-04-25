package com.conamobile.requestapigetmethod.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.conamobile.requestapigetmethod.R
import com.conamobile.requestapigetmethod.model.User
import com.google.android.material.imageview.ShapeableImageView

class UserAdapter(var context: Context, var items: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val home = items[position]

        if (holder is HomeViewHolder) {
            val userText = holder.userText
            val userImage = holder.userImage

            userText.text = home.login
            Glide.with(context)
                .load(home.avatar_url)
                .into(userImage)

        }
    }

    override fun getItemCount(): Int = items.size

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userText: AppCompatTextView = view.findViewById(R.id.user_text)
        var userImage: ShapeableImageView = view.findViewById(R.id.user_image)
    }
}