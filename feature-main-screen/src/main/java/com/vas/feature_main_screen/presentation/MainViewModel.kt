package com.vas.feature_main_screen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase

class MainViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val router: Router) : ViewModel() {

    val characterList = getCharacterListUseCase.execute()

    fun navigationToScreen(screen: FragmentScreen){
        Log.d("nav", router.toString())
        Log.d("nav", screen.toString())
        router.navigateTo(screen)
    }

}