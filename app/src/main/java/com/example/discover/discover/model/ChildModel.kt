package com.example.discover.discover.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChildModel(
    val drawable: Int,
    val origin: String,
    val age: Int,
    val size: String,
    val price: String,
    val name: String
) : Parcelable