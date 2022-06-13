package com.vas.feature_details_screen.domain.useCase

import androidx.lifecycle.LiveData
import com.vas.core.utils.Result
import com.vas.feature_details_screen.domain.model.CharacterDetails
import com.vas.feature_details_screen.domain.repository.DetailsRepository

class GetDetailsUseCase(private val detailsRepository: DetailsRepository) {

    fun execute(name: String): LiveData<Result<CharacterDetails>> {
        return detailsRepository.getDetailsResult(name)
    }
}