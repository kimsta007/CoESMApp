package coesmapp.com.coesmapp.models.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import coesmapp.com.coesmapp.models.LoginModel
import coesmapp.com.coesmapp.models.User


@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)
}