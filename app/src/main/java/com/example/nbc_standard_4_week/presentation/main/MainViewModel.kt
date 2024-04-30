package com.example.nbc_standard_4_week.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nbc_standard_4_week.data.CardRepositoryImpl
import com.example.nbc_standard_4_week.data.database.DataSource
import com.example.nbc_standard_4_week.data.database.dataList
import com.example.nbc_standard_4_week.presentation.model.DataModel
import com.example.nbc_standard_4_week.presentation.repository.SearchRepository
import java.text.DecimalFormat

class MainViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    // 총금액 변경
    private val _totalPrice: MutableLiveData<String> = MutableLiveData()
    val totalPrice: LiveData<String> get() = _totalPrice

    fun updateTotalPrice() {
        val decimal = DecimalFormat("#,##,###.00")
        _totalPrice.value = decimal.format(dataList().sumOf { it.price })
    }

    //6회차
    private val _getDataModel : MutableLiveData<List<DataModel>> = MutableLiveData()
    val getDataModel : LiveData<List<DataModel>> get() = _getDataModel
    fun getDataModel(){
        _getDataModel.value = searchRepository.getCardList()
    }
}

//todo 제네릭 공부
//viewModel에 어떤 타입으로 와도 유효하다면 사용
class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //어떤 뷰의 타입이 와도 제네릭으로 받을 수 있음
        return MainViewModel(CardRepositoryImpl(DataSource)) as T
    }
}