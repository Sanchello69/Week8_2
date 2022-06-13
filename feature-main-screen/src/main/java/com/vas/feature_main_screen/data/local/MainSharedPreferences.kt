package com.vas.feature_main_screen.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.vas.core.utils.Constants.CHARACTERS_PREF
import com.vas.feature_main_screen.data.model.CharacterData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MainSharedPreferences(private val context: Context) {

    private val mPrefs = context.getSharedPreferences(CHARACTERS_PREF, MODE_PRIVATE)
    private val mGson = GsonBuilder().create()

    fun getCharactersSharedPref() : LiveData<List<CharacterData>> = liveData(Dispatchers.IO) {
        try {
            val characterListJson = mPrefs.getString(CHARACTERS_PREF, "")
            val characterList : List<CharacterData> = mGson.fromJson(
                characterListJson,
                object : TypeToken<List<CharacterData>>(){}.type)


            emit(characterList!!)

        } catch (e: Exception){
            Log.d("error_get_pref", e.message.toString())
            emit(emptyList())
        }
    }

    suspend fun saveCharactersSharedPref(characterList: List<CharacterData>){
        withContext(Dispatchers.IO){
            try {
                val characterListJson = mGson.toJson(characterList)
                val editor = mPrefs.edit()

                editor.putString(CHARACTERS_PREF, characterListJson)
                editor.apply()

            } catch (e: Exception){
                Log.d("error_save_pref", e.message.toString())
            }
        }
    }
}