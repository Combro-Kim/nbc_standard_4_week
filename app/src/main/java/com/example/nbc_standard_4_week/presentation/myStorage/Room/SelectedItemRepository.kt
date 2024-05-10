//package com.example.nbc_standard_4_week.presentation.myStorage.Room
//
//import androidx.lifecycle.LiveData
//
//class SelectedItemRepository(val dao: SelectedItemDAO) {
//    suspend fun insertSelectedItem(selectedItem: SelectedItemEntity) {
//        dao.insertSelectedItem(selectedItem)
//    }
//
//    fun getAllSelectedItems(): LiveData<List<SelectedItemEntity>> {
//        return dao.getAllSelectedItems()
//    }
//
//    suspend fun deleteSelectedItem(selectedItem: SelectedItemEntity) {
//        dao.deleteSelectedItem(selectedItem)
//    }
//}