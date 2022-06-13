package com.vas.feature_details_screen.data.local

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.GsonBuilder
import com.vas.core.utils.Constants.CHARACTERS_PREF
import com.vas.feature_details_screen.data.model.CharacterDetailsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsSharedPreferences(private val context: Context) {

    private val mGson = GsonBuilder().create()

    fun getCharacterDetailsSharedPref(name: String) : LiveData<CharacterDetailsData> =
        liveData(Dispatchers.IO) {
        try {
            val mPrefs = context.getSharedPreferences(
                CHARACTERS_PREF + name,
                Context.MODE_PRIVATE
            )

            val characterDetailsJson = mPrefs.getString(CHARACTERS_PREF + name, "")
            val characterDetails = mGson.fromJson(
                characterDetailsJson,
                CharacterDetailsData::class.java)
            emit(characterDetails!!)

        } catch (e: Exception){
            Log.d("error_get_pref", e.message.toString())
        }
    }

    suspend fun saveCharacterDetailsSharedPref(character: CharacterDetailsData){
        withContext(Dispatchers.IO){
            try {
                val mPrefs = context.getSharedPreferences(
                    CHARACTERS_PREF + character.name,
                    Context.MODE_PRIVATE
                )

                val characterDetailsJson = mGson.toJson(character)
                val editor = mPrefs.edit()

                editor.putString(CHARACTERS_PREF + character.name, characterDetailsJson)
                editor.apply()
            } catch (e: Exception){
                Log.d("error_save_pref", e.message.toString())
            }
        }
    }

}