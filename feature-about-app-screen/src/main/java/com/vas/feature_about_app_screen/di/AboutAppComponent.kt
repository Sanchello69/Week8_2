package com.vas.feature_about_app_screen.di

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.vas.feature_about_app_screen.AboutAppFragment
import dagger.Component
import kotlin.properties.Delegates

@Component(dependencies = [AboutAppDeps::class])
internal interface AboutAppComponent {
    fun inject(fragment: AboutAppFragment)

    @Component.Builder
    interface Builder {
        fun deps(deps: AboutAppDeps): Builder

        fun build(): AboutAppComponent
    }
}

interface AboutAppDeps {
    val router: Router
}

internal class AboutAppComponentViewModel : ViewModel(){

    val newAboutAppComponent = DaggerAboutAppComponent.builder().deps(AboutAppDepsProvider.deps).build()
}

interface AboutAppDepsProvider {
    val deps: AboutAppDeps

    companion object : AboutAppDepsProvider by AboutAppDepsStore
}

object AboutAppDepsStore : AboutAppDepsProvider {
    override var deps: AboutAppDeps by Delegates.notNull()
}