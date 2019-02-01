package coesmapp.com.coesmapp.models.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.math.BigInteger

@Entity(tableName = "user_details")
data class UserProfileEntity(
    @ColumnInfo(name = "property_owner") var propertyOwner: Boolean?,
    @ColumnInfo(name = "accept") val accept: Boolean?,
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "surname") var surname: String?,
    @ColumnInfo(name = "gender") var gender: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "identification_number") var identificationNumber: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "phone") var phone: Int?,
    @ColumnInfo(name = "prefer_method") var preferMethod: String?,
    @PrimaryKey(autoGenerate = false) val id: Int = 0
)