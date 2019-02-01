package coesmapp.com.coesmapp.models.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UserProfileDao {

    @Query("SELECT * FROM user_details LIMIT 1")
    fun getUserProfile(): UserProfileEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserProfileEntity)
}