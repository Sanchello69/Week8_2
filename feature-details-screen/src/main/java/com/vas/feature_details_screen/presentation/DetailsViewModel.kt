package com.vas.feature_details_screen.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase

class DetailsViewModel(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val router: Router) : ViewModel() {

    fun getDetails(name: String) = getDetailsUseCase.execute(name)

    fun navigationBack(){
        router.backTo(null)
    }
}