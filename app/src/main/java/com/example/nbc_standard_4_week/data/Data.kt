package com.example.nbc_standard_4_week.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val id: Int,
    val type: ViewType,
    val tvName: String,
    val num1: String,
    val YM: String,
    val price: Double
) : Parcelable
