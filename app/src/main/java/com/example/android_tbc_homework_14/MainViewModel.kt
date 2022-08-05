package com.example.android_tbc_homework_14

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_tbc_homework_14.model.Items
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _myFlow = MutableSharedFlow<Items>()
    val myFlow: SharedFlow<Items> get() = _myFlow

    fun getInformation() {
        viewModelScope.launch {
            val response = RetrofitInstance.getData().info()
            val body: Items? = response.body()
            if (response.isSuccessful && body != null) {
                _myFlow.emit(body)
            }
        }
    }
}