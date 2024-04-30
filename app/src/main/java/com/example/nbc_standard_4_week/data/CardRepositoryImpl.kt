package com.example.nbc_standard_4_week.data

import com.example.nbc_standard_4_week.data.database.DataSource
import com.example.nbc_standard_4_week.presentation.mapper.asCardModel
import com.example.nbc_standard_4_week.presentation.model.DataModel
import com.example.nbc_standard_4_week.presentation.repository.SearchRepository

class CardRepositoryImpl(private val dataSource : DataSource): SearchRepository {
    override fun getCardList(): List<DataModel> {
        return dataSource.getDataList().asCardModel()
    }
}