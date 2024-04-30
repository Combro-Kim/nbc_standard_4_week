package com.example.nbc_standard_4_week.data.database

import com.example.nbc_standard_4_week.data.entity.DataEntity


// todo synchronized말고 다른 방법으로 singleTon 구현하기***

object DataSource {
    fun getDataList(): List<DataEntity> {
        return dataList()
    }
}

//INSTANCE ?
// 클래스 내에서 단일 인스턴스를 유지하기 위해 사용된다. SingleTon패턴을 구현하기위해 사용

