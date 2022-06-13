package com.vas.feature_main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase

class MainViewModelFactory(val getCharacterListUseCase: GetCharacterListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                getCharacterListUseCase = getCharacterListUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}