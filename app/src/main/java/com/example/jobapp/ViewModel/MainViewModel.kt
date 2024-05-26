package com.example.jobapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.jobapp.Repository.MainRepository

class MainViewModel(val respository:MainRepository): ViewModel() {
    constructor():this(MainRepository())
    fun loadLocation()=respository.location
    fun loadLCategory()=respository.category
    fun loadData()=respository.items
}