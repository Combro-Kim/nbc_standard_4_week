package com.example.nbc_standard_4_week.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.data.dataList

class DetailViewModel:ViewModel() {

    //단순 받아온 데이터를 보여주기 때문에 LiveData 사용 안함
    private val dataList: MutableList<Data> =  dataList()

    fun getDataForId(id:Int): Data? {
        return dataList.find { it.id == id }
    }
}