package com.vas.feature_main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase

class MainViewModelFactory(
    val getCharacterListUseCase: GetCharacterListUseCase,
    private val router: Router) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                getCharacterListUseCase = getCharacterListUseCase,
                router = router
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}