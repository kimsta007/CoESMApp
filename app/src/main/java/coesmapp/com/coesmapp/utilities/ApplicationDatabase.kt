package coesmapp.com.coesmapp.utilities;

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import coesmapp.com.coesmapp.models.LoginModel
import coesmapp.com.coesmapp.models.room.LoginDao


@Database(entities = arrayOf(LoginModel::class), version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): LoginDao
}