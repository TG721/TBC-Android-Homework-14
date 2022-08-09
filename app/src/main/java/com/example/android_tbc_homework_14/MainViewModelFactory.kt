package com.example.android_tbc_homework_14

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_tbc_homework_14.repository.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return (MainViewModel(repository) as T)
    }
}