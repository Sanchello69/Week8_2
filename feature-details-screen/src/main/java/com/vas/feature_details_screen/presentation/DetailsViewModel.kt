package com.vas.feature_details_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase
import kotlinx.coroutines.Dispatchers

class DetailsViewModel(private val getDetailsUseCase: GetDetailsUseCase) : ViewModel() {

    fun getDetails(name: String) = getDetailsUseCase.execute(name)
}