package coesmapp.com.coesmapp.di

import coesmapp.com.coesmapp.repository.LoginRepository
import coesmapp.com.coesmapp.repository.RegistrationRepository
import org.koin.dsl.module.module
/**
 * provide Repository classes for implementation in Koin DI
 *
 */
val repositoryModules = module {
    single { LoginRepository(get(), get()) }
    single { RegistrationRepository(get(), get()) }
}