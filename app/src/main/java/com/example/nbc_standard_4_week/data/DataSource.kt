package com.example.nbc_standard_4_week.data

class DataSource {
//    private var dataList: MutableList<Data> = dataList()

    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getDataList(): MutableList<Data> {
        return dataList()
    }
}

//INSTANCE ?
// 클래스 내에서 단일 인스턴스를 유지하기 위해 사용된다. SingleTon패턴을 구현하기위해 사용

