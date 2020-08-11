package com.fort0.wwenxtroster

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RosterAdapter(private val listSuperstar: ArrayList<Superstar>) :
    RecyclerView.Adapter<RosterAdapter.SuperstarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): SuperstarViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.superstar_row, parent, false)
        return SuperstarViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listSuperstar.size

    }

    override fun onBindViewHolder(holder: SuperstarViewHolder, position: Int) {
        val (name, title, image, imageDetail, detail) = listSuperstar[position]

        Glide.with(holder.itemView.context)
            .load(image)
            .apply(RequestOptions().override(500, 500))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvTitle.text = title

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_NAME, name)
            moveDetail.putExtra(DetailActivity.EXTRA_IMAGE, imageDetail)
            moveDetail.putExtra(DetailActivity.EXTRA_DETAILS, detail)
            mContext.startActivity(moveDetail)

        }
    }

    inner class SuperstarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.superstar_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.superstar_image)
        var tvTitle: TextView = itemView.findViewById(R.id.superstar_title)

    }
}