package com.example.nbc_standard_4_week.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.nbc_standard_4_week.data.Data
import com.example.nbc_standard_4_week.data.dataList

class DetailViewModel : ViewModel() {

    private val dataList: MutableList<Data> = dataList()
    fun getDataForId(id: Int): Data? {
        return dataList.find { it.id == id }
    }


    //LiveData 사용
    //단순 받아온 데이터를 보여주기 때문에 LiveData 사용 안함
/*    private val _dataList: MutableLiveData<List<Data>> = MutableLiveData()
    val dataList: LiveData<List<Data>> get() = _dataList

    init {
        _dataList.value = dataList()
    }

    fun getDataForId(id:Int):LiveData<Data?>{
        return dataList.map { list ->
            list.find { it.id == id }
        }
    }*/


}