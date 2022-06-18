package com.vas.week7_2.navigation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.vas.feature_about_app_screen.AboutAppFragment
import com.vas.feature_details_screen.presentation.DetailsFragment
import com.vas.feature_main_screen.navigation.MainScreenProvider
import javax.inject.Inject

class MainScreenProviderImpl @Inject constructor() : MainScreenProvider {

    override fun AboutApp() = FragmentScreen { AboutAppFragment() }
    override fun Details(bundle: Bundle) = FragmentScreen {
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        fragment}
}