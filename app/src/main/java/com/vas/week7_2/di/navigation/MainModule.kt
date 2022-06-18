package com.vas.week7_2.di.navigation

import com.vas.feature_main_screen.navigation.MainScreenProvider
import com.vas.week7_2.navigation.MainScreenProviderImpl
import dagger.Binds
import dagger.Module

@Module
interface MainModule{

    @Binds
    fun bindMainNavigator(impl: MainScreenProviderImpl): MainScreenProvider

}