package com.example.discover.discover.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.discover.R
import com.example.discover.databinding.FragmentItemDetailsBinding

class ItemDetailsFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_item_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        binding.childModel =
            requireArguments().getParcelable(DiscoverFragment.KEY_CHILD_MODEL)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.clear()
    }
}