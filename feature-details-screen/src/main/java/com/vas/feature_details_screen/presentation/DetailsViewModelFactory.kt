package com.vas.feature_details_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase

class DetailsViewModelFactory(
    val getDetailsUseCase: GetDetailsUseCase,
    val router: Router) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(
                getDetailsUseCase = getDetailsUseCase,
                router = router
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}