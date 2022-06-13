package com.vas.feature_main_screen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.vas.core.utils.Result
import com.vas.core.utils.resultLiveData
import com.vas.feature_main_screen.data.local.MainSharedPreferences
import com.vas.feature_main_screen.data.network.ApiHelper
import com.vas.feature_main_screen.domain.model.Character
import com.vas.feature_main_screen.domain.repository.MainRepository

class MainRepositoryImpl(private val apiHelper: ApiHelper,
                         private val mainSharedPreferences: MainSharedPreferences): MainRepository {

    private val resultMainLiveData = resultLiveData(
        sharedPrefQuery = {mainSharedPreferences.getCharactersSharedPref()},
        networkCall = {apiHelper.getCharacterListResult()},
        saveCallResult = {mainSharedPreferences.saveCharactersSharedPref(it)}
    ).map {
        Result<List<Character>>(
            status = it.status,
            message = it.message,
            data = it.data?.map {
                Character(
                    name = it.name,
                    urlIcon = it.urlIcon
                )
            }
        )
    }

    override fun getCharacterListResult() : LiveData<Result<List<Character>>> {
        return resultMainLiveData
    }
}