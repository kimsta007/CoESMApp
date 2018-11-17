package coesmapp.com.coesmapp


import android.app.Application
import android.arch.persistence.room.Room
import coesmapp.com.coesmapp.repository.LoginRepository
import coesmapp.com.coesmapp.utilities.AppDatabase
import coesmapp.com.coesmapp.viewmodels.ContactDetailsViewModel
import coesmapp.com.coesmapp.viewmodels.LoginViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class CoeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /**
         * start the Koin dependency injection on a
         * @param   context
         * @param   listOf<Modules>()
         */
        startKoin(
            this,
            listOf(
                generalModule(),
                getNetworkingModule(),
                getDatabaseModule(),
                getRepositoryModules(),
                getViewModelModule()
            )
        )
    }


    private fun generalModule(): Module = module {
        single(name = "context") { applicationContext }
    }

    /**
     * provide and create ned
     */
    private fun getNetworkingModule(): Module = module {

    }

    /**
     * provide database creation and expose DAO for implementation by Koin DI
     *
     * TODO: will move this module to the di package to provide a more lean application class
     */
    private fun getDatabaseModule(): Module = module {
        single { Room.databaseBuilder(get("context"), AppDatabase::class.java, "application_db").build() }
        single { get<AppDatabase>().userDao() }
    }

    /**
     * provide Repository classes for implementation in Koin DI
     *
     * TODO: will move this module to the di package to provide a more lean application class
     */
    private fun getRepositoryModules(): Module = module {
        single { LoginRepository() }
    }

    /**
     * provide all view model classes for implementation in Koin DI
     *
     * TODO: will move this module to the di package to provide a more lean application class
     */
    private fun getViewModelModule(): Module = module {
        viewModel { LoginViewModel() }
        viewModel { ContactDetailsViewModel() }
    }
}