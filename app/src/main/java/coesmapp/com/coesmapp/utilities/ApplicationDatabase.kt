package coesmapp.com.coesmapp.utilities;

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import coesmapp.com.coesmapp.models.room.LoginDao
import coesmapp.com.coesmapp.models.room.UserProfileDao
import coesmapp.com.coesmapp.models.room.UserProfileEntity


@Database(entities = [UserProfileEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): LoginDao
    abstract fun userProfileDao(): UserProfileDao
}