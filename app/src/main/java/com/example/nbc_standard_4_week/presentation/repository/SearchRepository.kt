package com.example.nbc_standard_4_week.presentation.repository

import com.example.nbc_standard_4_week.presentation.model.DataModel

interface SearchRepository {
    fun getCardList() : List<DataModel> //Model
}