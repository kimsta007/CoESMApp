package coesmapp.com.coesmapp.utilities;

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import coesmapp.com.coesmapp.models.LoginModel
import coesmapp.com.coesmapp.models.User
import coesmapp.com.coesmapp.models.room.LoginDao


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): LoginDao
}