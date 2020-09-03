package com.shivaprasad.phabelcaretask.data.api
import android.content.Context
import androidx.lifecycle.LiveData
import com.shivaprasad.phabelcaretask.data.db.AppDataBase
import com.shivaprasad.phabelcaretask.data.entities.ContactDataEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(
    private val appDataBase: AppDataBase
) {

    suspend fun saveEmployeesData(contactDataEntity: ContactDataEntity) = appDataBase.getNewsDAO().insert(contactDataEntity)


    suspend fun getAllEmployesData(): List<ContactDataEntity>{
        return appDataBase.getNewsDAO().getAllContacsData()
    }

    suspend fun update(entity: ContactDataEntity){
        appDataBase.getNewsDAO().update(entity);
    }

    suspend fun delete(entity: ContactDataEntity){
        appDataBase.getNewsDAO().delete(entity);
    }
}