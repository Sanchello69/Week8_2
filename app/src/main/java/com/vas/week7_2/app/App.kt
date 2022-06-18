package com.vas.week7_2.app

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.vas.feature_about_app_screen.di.AboutAppDepsStore
import com.vas.feature_details_screen.di.DetailsDepsStore
import com.vas.feature_main_screen.di.MainDepsStore
import com.vas.week7_2.di.AppComponent
import com.vas.week7_2.di.AppModule
import com.vas.week7_2.di.DaggerAppComponent

class App : Application(){

    lateinit var appComponent: AppComponent

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        appComponent = DaggerAppComponent.builder().appModule(
            AppModule(
                context = this,
                cicerone = cicerone)
        ).build()

        MainDepsStore.deps = appComponent
        DetailsDepsStore.deps = appComponent
        AboutAppDepsStore.deps = appComponent
    }

    companion object {
        lateinit var INSTANCE: App
    }

}