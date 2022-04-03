package com.kunal.physicswallah.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunal.physicswallah.R
import com.kunal.physicswallah.data.network.models.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_list_item.view.*

class DataAdapter(
    private val list: List<Data>
) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Data) {
            itemView.name.text = data.name
            itemView.details.text = "${data.subjects[0]} · ${data.qualification[0]}"
            Picasso.get().load(data.profileImage).into(itemView.coverImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    override fun getItemCount() = list.size
}