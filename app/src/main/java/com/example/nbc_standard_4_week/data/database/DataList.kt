package com.example.nbc_standard_4_week.data.database

import com.example.nbc_standard_4_week.presentation.ViewTypeEnum
import com.example.nbc_standard_4_week.data.entity.DataEntity

fun dataList(): List<DataEntity> {
    return listOf(
        DataEntity(
            id = 0,
            type = ViewTypeEnum.CARD1,
            tvName = "Anderson",
            num1 = "2423358195032412",
            YM = "21/24",
            price = 3100.30
        ),
        DataEntity(
            id = 1,
            type = ViewTypeEnum.CARD2,
            tvName = "John",
            num1 = "1234567898765432",
            YM = "21/24",
            price = 2459.60
        ),
        DataEntity(
            id = 2,
            type = ViewTypeEnum.CARD3,
            tvName = "Mash",
            num1 = "4564456478954125",
            YM = "21/24",
            price = 4567.20
        ),
    )
}