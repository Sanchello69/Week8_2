package com.vas.week7_2.di

import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase
import com.vas.feature_details_screen.presentation.DetailsViewModelFactory
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase
import com.vas.feature_main_screen.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context, val cicerone: Cicerone<Router>) {

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideCicerone() : Cicerone<Router> {
        return cicerone
    }

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>) : Router {
        return cicerone.router
    }

    @Provides
    fun provideMainViewModelFactory(
        getCharacterListUseCase: GetCharacterListUseCase,
        router: Router): MainViewModelFactory {
        return MainViewModelFactory(
            getCharacterListUseCase = getCharacterListUseCase,
            router = router)
    }

    @Provides
    fun provideDetailsViewModelFactory(
        getDetailsUseCase: GetDetailsUseCase,
        router: Router): DetailsViewModelFactory {
        return DetailsViewModelFactory(
            getDetailsUseCase = getDetailsUseCase,
            router = router)
    }
}