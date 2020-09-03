package com.shivaprasad.phabelcaretask.data.entities
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contactDataEntity: ContactDataEntity)

    @Query("SELECT * FROM ContactDataEntity")
    suspend fun getAllContacsData() :  List<ContactDataEntity>

    @Delete
    suspend fun delete(entity: ContactDataEntity)

    @Update
    suspend fun update(entity: ContactDataEntity)


}