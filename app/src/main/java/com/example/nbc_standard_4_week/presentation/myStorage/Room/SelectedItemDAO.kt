package com.example.nbc_standard_4_week.presentation.myStorage.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SelectedItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSelectedItem(selectedItem: SelectedItemEntity)

    @Query("SELECT * FROM selected_items")
    fun getAllSelectedItems(): LiveData<List<SelectedItemEntity>> // LiveData

    @Delete
    suspend fun deleteSelectedItem(selectedItem: SelectedItemEntity)
}