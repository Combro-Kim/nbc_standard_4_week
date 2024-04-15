package com.example.nbc_standard_4_week.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val type:Int,

    val tvName: String,
    val num1:Int,
    val num2:Int,
    val num3: Int,
    val num4: Int,
    val YM: String,
    val price: Double
):Parcelable
