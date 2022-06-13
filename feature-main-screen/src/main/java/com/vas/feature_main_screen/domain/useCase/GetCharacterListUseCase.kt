package com.vas.feature_main_screen.domain.useCase

import androidx.lifecycle.LiveData
import com.vas.core.utils.Result
import com.vas.feature_main_screen.domain.model.Character
import com.vas.feature_main_screen.domain.repository.MainRepository

class GetCharacterListUseCase(private val mainRepository: MainRepository) {

    fun execute(): LiveData<Result<List<Character>>> {
        return mainRepository.getCharacterListResult()
    }
}