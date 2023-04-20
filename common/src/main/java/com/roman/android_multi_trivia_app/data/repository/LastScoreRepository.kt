package com.roman.android_multi_trivia_app.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.roman.android_multi_trivia_app.data.repository.LastScoreRepository.Companion.PREFERENCE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.lastScoreDataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

class LastScoreRepository (
    context: Context
) {

    companion object {
        const val PREFERENCE_NAME = "last_score_preferences"
        const val PREFERENCE_KEY = "last_Score"
    }

    private object PreferenceKeys {
        val lastScoreKey = intPreferencesKey(PREFERENCE_KEY)
    }

    private val dataStore = context.lastScoreDataStore

    suspend fun persistLastScore(lastScore: Int) {
        dataStore.edit { preference ->
            preference[PreferenceKeys.lastScoreKey] = lastScore
        }
    }

    val readLastScore: Flow<Int> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val lastScore = preferences[PreferenceKeys.lastScoreKey] ?: 0
            lastScore
        }
}