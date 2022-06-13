package com.vas.feature_details_screen.data.network

import com.vas.core.utils.Constants.CHARACTERS_URL
import com.vas.feature_details_screen.data.model.CharacterDetailsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetailsInterface {
    @GET(CHARACTERS_URL)
    suspend fun getDetailsResult(@Query("name") name: String): Response<List<CharacterDetailsData>>
}