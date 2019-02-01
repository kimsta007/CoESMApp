package coesmapp.com.coesmapp


import android.app.Application
import android.arch.persistence.room.Room
import coesmapp.com.coesmapp.di.databaseModules
import coesmapp.com.coesmapp.di.generalModules
import coesmapp.com.coesmapp.di.repositoryModules
import coesmapp.com.coesmapp.di.viewModelModules
import coesmapp.com.coesmapp.repository.LoginRepository
import coesmapp.com.coesmapp.repository.RegistrationRepository
import coesmapp.com.coesmapp.utilities.AppDatabase
import coesmapp.com.coesmapp.viewmodels.ContactDetailsViewModel
import coesmapp.com.coesmapp.viewmodels.LoginViewModel
import coesmapp.com.coesmapp.viewmodels.RegistrationViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import java.security.Permission
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

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
                applicationContextModule,
                generalModules,
                getNetworkingModule(),
                databaseModules,
                repositoryModules,
                viewModelModules
            )
        )
    }


    private val applicationContextModule = module{
        single(name = "context") { applicationContext }
    }

    /**
     * provide and create webservice instances
     */
    private fun getNetworkingModule(): Module = module {

    }

}