package com.ahincho.data.store

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.ahincho.data.store.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val Context.dataStore by preferencesDataStore(name = "USER_PREFERENCES_NAME")

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                saveValues(binding.etName.text.toString(), binding.cbVip.isChecked)
            }
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
    private suspend fun saveValues(name: String, vip: Boolean) {
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey("name")] = name
            preferences[booleanPreferencesKey("vip")] = vip
        }
    }
}