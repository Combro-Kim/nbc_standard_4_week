package com.example.nbc_standard_4_week.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val id: Int,
    val type: ViewType,
    val tvName: String,
    val num1: Int,
    val num2: Int,
    val num3: Int,
    val num4: Int,
    val YM: String,
    val price: Double
) : Parcelable
