package coesmapp.com.coesmapp.utilities;

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import coesmapp.com.coesmapp.models.room.*


@Database(entities = [UserProfileEntity::class, UserAddressEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): LoginDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun userAddressDao(): UserAddressDao
}