package com.vas.feature_details_screen.data.network

import com.vas.core.utils.BaseDataSource

class ApiDetailsHelper(private val apiInterface: ApiDetailsInterface) : BaseDataSource() {

    suspend fun getDetailsResult(name: String) = getResult { apiInterface.getDetailsResult(name) }

}