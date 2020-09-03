package com.shivaprasad.phabelcaretask.data.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ContactDataEntity(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "emailid")
    var emailid: String
):Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "SNO")
    var id: Int = 0
}
