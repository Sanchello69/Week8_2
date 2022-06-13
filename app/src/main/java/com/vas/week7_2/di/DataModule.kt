package com.vas.week7_2.di

import android.content.Context
import com.vas.feature_details_screen.data.local.DetailsSharedPreferences
import com.vas.feature_details_screen.data.network.ApiDetailsHelper
import com.vas.feature_details_screen.data.network.RetrofitDetailsClient
import com.vas.feature_details_screen.data.repository.DetailsRepositoryImpl
import com.vas.feature_details_screen.domain.repository.DetailsRepository
import com.vas.feature_main_screen.data.local.MainSharedPreferences
import com.vas.feature_main_screen.data.network.ApiHelper
import com.vas.feature_main_screen.data.network.RetrofitClient
import com.vas.feature_main_screen.data.repository.MainRepositoryImpl
import com.vas.feature_main_screen.domain.repository.MainRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiHelper(): ApiHelper {
        return ApiHelper(RetrofitClient.apiInterface)
    }

    @Provides
    fun provideMainRepository(apiHelper: ApiHelper, mainSharedPreferences: MainSharedPreferences):
            MainRepository{
        return MainRepositoryImpl(apiHelper = apiHelper, mainSharedPreferences = mainSharedPreferences)
    }

    @Provides
    fun provideMainSharedPreferences(context: Context): MainSharedPreferences {
        return MainSharedPreferences(context)
    }

    @Provides
    fun provideDetailsApiHelper(): ApiDetailsHelper{
        return ApiDetailsHelper(RetrofitDetailsClient.apiInterface)
    }

    @Provides
    fun provideDetailsRepository(
        apiHelper: ApiDetailsHelper,
        detailsSharedPreferences: DetailsSharedPreferences): DetailsRepository{
        return DetailsRepositoryImpl(apiHelper = apiHelper, detailsShPref = detailsSharedPreferences)
    }

    @Provides
    fun provideDetailsSharedPreferences(context: Context): DetailsSharedPreferences {
        return DetailsSharedPreferences(context)
    }
}