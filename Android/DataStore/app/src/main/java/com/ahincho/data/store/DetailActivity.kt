package com.ahincho.data.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.ahincho.data.store.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch(Dispatchers.IO) {
            getUserProfile().collect { userProfile ->
                withContext(Dispatchers.Main) {
                    binding.tvName.text = userProfile.name
                    if (userProfile.vip) {
                        binding.clContainer.setBackgroundResource(R.color.gold)
                    }
                }
            }
        }
    }
    private fun getUserProfile(): Flow<UserProfile> {
        return dataStore.data.map { preferences ->
            UserProfile (
                name = preferences[stringPreferencesKey("name")].orEmpty(),
                vip = preferences[booleanPreferencesKey("vip")] ?: false
            )
        }
    }
}