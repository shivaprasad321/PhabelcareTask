package com.shivaprasad.phabelcaretask.data.db
import com.shivaprasad.phabelcaretask.data.entities.ContactDAO
import com.shivaprasad.phabelcaretask.data.entities.ContactDataEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(
    entities = [ContactDataEntity::class],
    version = 1,
    exportSchema = false

)

abstract class AppDataBase : RoomDatabase() {

    abstract fun getNewsDAO(): ContactDAO

    companion object {
        @Volatile
        private var instence: AppDataBase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instence
            ?: synchronized(LOCK) {
            instence
                ?: buildDatabase(
                    context
                ).also {
                instence = it
            }

        }

        private fun buildDatabase(context: Context) =
            databaseBuilder(
                context,
                AppDataBase::class.java,
                "contactsdata.db"

            ).build()
    }


}