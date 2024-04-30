package com.example.nbc_standard_4_week.presentation.mapper

import com.example.nbc_standard_4_week.data.entity.DataEntity
import com.example.nbc_standard_4_week.presentation.model.DataModel

fun List<DataEntity>.asCardModel(): List<DataModel> {
    return map {
        DataModel(
            it.id,
            it.type,
            it.tvName,
            it.num1,
            it.YM,
            it.price
        )
    }
}
