package coesmapp.com.coesmapp.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

data class LoginModel(val username: String, val password: String)

enum class Gender { MALE, FEMALE }

@Entity(tableName = "user_details")
data class User(
    @ColumnInfo(name = "property_owner") val propertyOwner: Boolean,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "surname") val surname: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "identification_number") val identificationNumber: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: Int,
    @PrimaryKey(autoGenerate = false) val id: Int = 0
)