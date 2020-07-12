package com.example.fragmentscommunicatorusingviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SharedViewModel : ViewModel() {

    private val selected = MutableLiveData<Int>()

    fun select(i: Int) {
        selected.value = i
    }

    fun getSelected(): LiveData<Int> {
        return selected
    }
}

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SharedViewModel() as T
    }
}

