package coesmapp.com.coesmapp.di

import org.koin.dsl.module.module
import java.util.concurrent.Executors

val generalModules = module {
    single { Executors.newCachedThreadPool() }
}