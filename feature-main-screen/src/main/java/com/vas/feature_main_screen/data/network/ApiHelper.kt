package com.vas.feature_main_screen.data.network

import com.vas.core.utils.BaseDataSource

class ApiHelper (private val apiInterface: ApiInterface) : BaseDataSource(){
    suspend fun getCharacterListResult() =
        getResult { apiInterface.getCharacterListResult() }
}