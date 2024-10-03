package com.example.kt3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var liveData = MutableLiveData<String>()

    fun changeString(string: String) {
        liveData.value = string
    }
}