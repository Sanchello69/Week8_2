package com.vas.feature_main_screen.navigation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface MainScreenProvider {

    fun AboutApp() : FragmentScreen
    fun Details(bundle: Bundle) : FragmentScreen

}