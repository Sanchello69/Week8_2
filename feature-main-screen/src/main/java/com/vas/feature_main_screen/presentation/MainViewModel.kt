package com.vas.feature_main_screen.presentation

import androidx.lifecycle.ViewModel
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase

class MainViewModel(private val getCharacterListUseCase: GetCharacterListUseCase) : ViewModel() {

    val characterList = getCharacterListUseCase.execute()

}