package com.vas.feature_details_screen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.vas.core.utils.Result
import com.vas.core.utils.resultLiveData
import com.vas.feature_details_screen.data.local.DetailsSharedPreferences
import com.vas.feature_details_screen.data.network.ApiDetailsHelper
import com.vas.feature_details_screen.domain.model.CharacterDetails
import com.vas.feature_details_screen.domain.repository.DetailsRepository

class DetailsRepositoryImpl(
    private val apiHelper: ApiDetailsHelper,
    private val detailsShPref: DetailsSharedPreferences): DetailsRepository {

    override fun getDetailsResult(name: String): LiveData<Result<CharacterDetails>> {

        val resultDetailsLiveData = resultLiveData(
            sharedPrefQuery = {detailsShPref.getCharacterDetailsSharedPref(name)},
            networkCall = {apiHelper.getDetailsResult(name)},
            saveCallResult = {detailsShPref.saveCharacterDetailsSharedPref(it.first())}
        )

        return resultDetailsLiveData.map {
            Result(
                status = it.status,
                message = it.message,
                data = it.data?.let {
                    CharacterDetails(
                        name = it.name,
                        urlIcon = it.urlIcon,
                        characterType = it.characterType,
                        powers = it.powers
                    )
                }
            )
        }
    }
}