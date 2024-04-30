package com.example.nbc_standard_4_week.data.entity

import com.example.nbc_standard_4_week.presentation.ViewTypeEnum


data class DataEntity(
    val id: Int,
    val type: ViewTypeEnum,
    val tvName: String,
    val num1: String,
    val YM: String,
    val price: Double
)
