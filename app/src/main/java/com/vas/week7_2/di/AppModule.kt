package com.vas.week7_2.di

import android.content.Context
import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase
import com.vas.feature_details_screen.presentation.DetailsViewModelFactory
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase
import com.vas.feature_main_screen.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(getCharacterListUseCase: GetCharacterListUseCase): MainViewModelFactory {
        return MainViewModelFactory(getCharacterListUseCase = getCharacterListUseCase)
    }

    @Provides
    fun provideDetailsViewModelFactory(getDetailsUseCase: GetDetailsUseCase): DetailsViewModelFactory {
        return DetailsViewModelFactory(getDetailsUseCase = getDetailsUseCase)
    }
}