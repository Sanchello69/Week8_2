package com.vas.feature_main_screen.domain.repository

import androidx.lifecycle.LiveData
import com.vas.core.utils.Result
import com.vas.feature_main_screen.domain.model.Character

interface MainRepository {
    fun getCharacterListResult() : LiveData<Result<List<Character>>>
}