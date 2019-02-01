package coesmapp.com.coesmapp.di

import android.arch.persistence.room.Room
import coesmapp.com.coesmapp.utilities.AppDatabase
import org.koin.dsl.module.module


/**
 * provide database creation and expose DAO for implementation by Koin DI
 *
 */
val databaseModules = module {
    single { Room.databaseBuilder(get("context"), AppDatabase::class.java, "application_db").build() }
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().userProfileDao() }
}