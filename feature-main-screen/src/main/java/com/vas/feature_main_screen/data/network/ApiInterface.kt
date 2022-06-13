package com.vas.feature_main_screen.data.network

import com.vas.core.utils.Constants.CHARACTERS_URL
import com.vas.feature_main_screen.data.model.CharacterData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET(CHARACTERS_URL)
    suspend fun getCharacterListResult(): Response<List<CharacterData>>
}