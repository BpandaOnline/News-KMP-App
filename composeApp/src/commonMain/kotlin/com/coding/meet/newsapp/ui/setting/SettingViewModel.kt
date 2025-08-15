package com.coding.meet.newsapp.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coding.meet.newsapp.ui.common.videmodel.KmpViewModel
import com.coding.meet.newsapp.utils.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SettingViewModel(
    private val appPreferences: AppPreferences
) : KmpViewModel(){
    private val _currentThem: MutableStateFlow<String?> = MutableStateFlow(null)

    val currentTheme = _currentThem.asStateFlow()

    init {
        currentThemeGet()
    }

    private fun currentThemeGet() = runBlocking {
        _currentThem.update {
            appPreferences.getTheme()
        }
    }

    fun changeThemeMode(value: String){
        viewModelScope.launch(Dispatchers.IO) {
            appPreferences.changeThemeMode(value)
            _currentThem.update {
                value
            }
        }
    }
}