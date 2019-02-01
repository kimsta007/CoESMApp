package coesmapp.com.coesmapp.di

import coesmapp.com.coesmapp.viewmodels.ContactDetailsViewModel
import coesmapp.com.coesmapp.viewmodels.LoginViewModel
import coesmapp.com.coesmapp.viewmodels.RegistrationViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * provide all view model classes for implementation in Koin DI
 *
 */
val viewModelModules = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegistrationViewModel(get()) }
    viewModel { ContactDetailsViewModel() }
}