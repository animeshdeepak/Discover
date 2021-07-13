package com.example.discover.discover.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.discover.R
import com.example.discover.databinding.FragmentDiscoverBinding
import com.example.discover.discover.adapter.ParentAdapter
import com.example.discover.discover.model.ParentModel

class DiscoverFragment : Fragment() {
    companion object {
        const val KEY_CHILD_MODEL = "child_model"
    }

    private lateinit var binding: FragmentDiscoverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discover, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        setUpAdapter()
    }

    private fun setUpAdapter() {
        val parentList = ArrayList<ParentModel>()
        parentList.apply {
            add(ParentModel("Most Popular"))
            add(ParentModel("Dogs"))
            add(ParentModel("Other"))
        }
        binding.apply {
            val adapter = ParentAdapter(parentList)
            rvDiscover.setHasFixedSize(true)
            rvDiscover.adapter = adapter

            adapter.onSeeAllItemClick = {

            }

            adapter.onItemClick = {
                val bundle = bundleOf(KEY_CHILD_MODEL to it)

                findNavController().currentDestination?.getAction(R.id.action_discoverFragment_to_itemDetailsFragment)
                    ?.let {
                        findNavController().navigate(
                            R.id.action_discoverFragment_to_itemDetailsFragment,
                            bundle
                        )
                    }
            }
        }
        ViewCompat.setNestedScrollingEnabled(binding.rvDiscover, false);
    }
}