package com.example.nbc_standard_4_week.presentation.model

import android.os.Parcelable
import com.example.nbc_standard_4_week.presentation.ViewTypeEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    val id: Int,
    val type: ViewTypeEnum,
    val tvName: String,
    val num1: String,
    val YM: String,
    val price: Double
) : Parcelable