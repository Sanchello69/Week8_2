package com.vas.week7_2.di

import com.github.terrakok.cicerone.Router
import com.vas.feature_about_app_screen.di.AboutAppDeps
import com.vas.feature_details_screen.di.DetailsDeps
import com.vas.feature_details_screen.presentation.DetailsViewModelFactory
import com.vas.feature_main_screen.di.MainDeps
import com.vas.feature_main_screen.navigation.MainScreenProvider
import com.vas.feature_main_screen.presentation.MainViewModelFactory
import com.vas.week7_2.MainActivity
import com.vas.week7_2.di.navigation.MainModule
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class,
MainModule::class])
interface AppComponent : MainDeps, DetailsDeps, AboutAppDeps {

    override val mainViewModelFactory: MainViewModelFactory
    override val mainScreenProvider: MainScreenProvider

    override val detailsViewModelFactory: DetailsViewModelFactory

    override val router: Router

    fun inject(mainActivity: MainActivity)
}