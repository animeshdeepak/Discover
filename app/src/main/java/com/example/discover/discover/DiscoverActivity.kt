package com.example.discover.discover

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.discover.R
import com.google.android.material.appbar.MaterialToolbar

class DiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        setUpToolbar()
    }

    private fun setUpToolbar() {
        /**
         * on toolbar back button click
         */
        findViewById<MaterialToolbar>(R.id.topAppBar).apply {
            setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
}