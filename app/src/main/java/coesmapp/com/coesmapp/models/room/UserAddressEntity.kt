package coesmapp.com.coesmapp.models.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "address")
data class UserAddressEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    @ColumnInfo(name = "complex_name") var complexName: String?,
    @ColumnInfo(name = "unit") var unit: String?,
    @ColumnInfo(name = "street") var street: String?,
    @ColumnInfo(name = "suburb") var suburb: String?,
    @ColumnInfo(name = "postal_code") var postalCode: String?,
    @ColumnInfo(name = "company") var comapntName: String?,
    @ColumnInfo(name = "building") var buildingName: String?,
    @ColumnInfo(name = "street_number") var streetNumber: String?,
    @ColumnInfo(name = "province") var provice: String?
)
