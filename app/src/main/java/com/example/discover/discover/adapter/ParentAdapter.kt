package com.example.discover.discover.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.discover.R
import com.example.discover.databinding.RailListItemBinding
import com.example.discover.discover.model.ChildModel
import com.example.discover.discover.model.ParentModel

class ParentAdapter(private val parentList: ArrayList<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    var onSeeAllItemClick: ((childList: ArrayList<ChildModel>) -> Unit)? = null
    var onItemClick: ((childItem: ChildModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val binding = RailListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = parentList.size

    inner class ParentViewHolder(private val binding: RailListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            onSeeAllItemClick?.invoke(getChildModel())
        }

        fun bind() {
            binding.apply {
                parentModel = parentList[absoluteAdapterPosition]
                executePendingBindings()
            }

            setUpChildRecyclerView(binding)
        }
    }

    private fun setUpChildRecyclerView(binding: RailListItemBinding) {
        val itemDecorator =
            DividerItemDecoration(binding.root.context, DividerItemDecoration.HORIZONTAL).apply {
                setDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.horizonta_item_divider
                    )!!
                )
            }
        binding.rvRailList.apply {
            addItemDecoration(itemDecorator)
            setHasFixedSize(true)
            val childAdapter = ChildAdapter(getChildModel())
            adapter = childAdapter

            childAdapter.onItemClick = {
                onItemClick?.invoke(it)
            }
        }
    }

    private fun getChildModel(): ArrayList<ChildModel> {
        return ArrayList<ChildModel>().apply {
            add(ChildModel(R.drawable.dog1, "US", 3, "3Ft", "$150.99", "Jimmy"))
            add(ChildModel(R.drawable.dog2, "UK", 2, "3Ft", "$120.99", "Dollar"))
            add(ChildModel(R.drawable.dog3, "India", 3, "4Ft", "$150.99", "Jackky"))
            add(ChildModel(R.drawable.dog4, "Australia", 6, "3Ft", "$150.99", "Sam"))
            add(ChildModel(R.drawable.dog5, "Japan", 9, "5Ft", "$150.99", "Tom"))
            add(ChildModel(R.drawable.dog6, "US", 4, "3Ft", "$150.99", "Hachy"))
            add(ChildModel(R.drawable.dog7, "Germany", 4, "1Ft", "$150.99", "Sino"))
            add(ChildModel(R.drawable.dog8, "India", 3, "3Ft", "$150.99", "Tom"))
        }
    }
}