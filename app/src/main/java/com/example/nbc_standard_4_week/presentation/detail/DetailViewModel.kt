//package com.example.nbc_standard_4_week.presentation.detail
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.map
//import com.example.nbc_standard_4_week.data.entity.DataEntity
//import com.example.nbc_standard_4_week.data.database.dataList
//import com.example.nbc_standard_4_week.presentation.model.DataModel
//
//class DetailViewModel : ViewModel() {
//
////    private val dataEntityList: MutableList<DataEntity> = dataList()
////    fun getDataForId(id: Int): DataEntity? {
////        return dataEntityList.find { it.id == id }
////    }
//
//    //LiveData 사용
//    private val _dataList: MutableLiveData<List<DataModel>> = MutableLiveData()
//    val dataList: LiveData<List<DataModel>> get() = _dataList
//
//    init {
//        _dataList.value = dataList()
//    }
//
//    fun getDataForId(id:Int):LiveData<DataModel?>{
//        return dataList.map { list ->
//            list.find { it.id == id }
//        }
//    }
//}