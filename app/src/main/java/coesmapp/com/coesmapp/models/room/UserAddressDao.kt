package coesmapp.com.coesmapp.models.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UserAddressDao {

    @Query("SELECT * FROM address WHERE id = 0")
    fun getUserAddress(): UserAddressEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress(address: UserAddressEntity)
}