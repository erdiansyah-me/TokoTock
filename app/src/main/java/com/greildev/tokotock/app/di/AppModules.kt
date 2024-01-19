package com.greildev.tokotock.app.di

import com.greildev.tokotock.data.UserPreferencesRepository
import com.greildev.tokotock.data.UserRepository
import com.greildev.tokotock.data.UserRepositoryImpl
import com.greildev.tokotock.domain.usecases.OnboardingUseCase
import com.greildev.tokotock.domain.usecases.ThemeUseCase
import com.greildev.tokotock.ui.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userPreferencesModules = module {
    single{UserPreferencesRepository(get())}
}

val repositoryModules = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
}

val useCaseModules = module {
    factory { OnboardingUseCase(get()) }
    factory { ThemeUseCase(get()) }
}

val viewModelModules = module {
    viewModel { UserViewModel(get(), get() ) }
}