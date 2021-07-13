package com.example.discover.discover.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.discover.databinding.ItemDiscoverBinding
import com.example.discover.discover.model.ChildModel

class ChildAdapter(private val childList: ArrayList<ChildModel>) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    var onItemClick: ((item: ChildModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding = ItemDiscoverBinding.inflate(LayoutInflater.from(parent.context))
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = childList.size

    inner class ChildViewHolder(private val binding: ItemDiscoverBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.ivIcon.setOnClickListener {
                onItemClick?.invoke(childList[absoluteAdapterPosition])
            }

            binding.childModel = childList[absoluteAdapterPosition]
            binding.executePendingBindings()
        }
    }
}