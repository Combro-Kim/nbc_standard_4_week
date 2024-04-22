package com.example.nbc_standard_4_week.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nbc_standard_4_week.data.DataSource
import com.example.nbc_standard_4_week.data.dataList
import java.text.DecimalFormat

class MainViewModel(val dataSource: DataSource) : ViewModel() {

    //Live Data실습 (총금액 변경)
    private val _totalPrice: MutableLiveData<String> = MutableLiveData()
    val totalPrice: LiveData<String> get() = _totalPrice

    //금액 변경될 때마다 보내줄 수 있음
    fun updateTotalPrice() {
        val decimal = DecimalFormat("#,##,###.00")
        _totalPrice.value = decimal.format(dataList().sumOf { it.price })
    }


    val dataLiveData = dataSource.getDataList()

    // id
    private val _selectedDataId = MutableLiveData<Int>()
    val selectedDataId: LiveData<Int> get() = _selectedDataId
    fun onItemSelected(id: Int) {
        _selectedDataId.value = id
    }
}

//Factory [di를 사용하면 안써도 됨 - 튜터님]
//todo 제네릭 공부
class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //어떤 뷰의 타입이 와도 제네릭으로 받을 수 있음
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) { //유효성 확인 [modelClass가 MainViewModel의 하위 클래스인지 확인]
            return MainViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}