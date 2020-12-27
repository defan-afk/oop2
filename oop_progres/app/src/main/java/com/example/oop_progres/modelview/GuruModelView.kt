package com.example.oop_progres.modelview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.oop_progres.guru.GuruDatabase
import com.example.oop_progres.repository.GuruRepository
import com.example.oop_progres.model.Guru
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GuruModelView(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Guru>>
    private val repository: GuruRepository

    init {
        val guruDao = GuruDatabase.getDatabase(
            application
        ).guruDao()
        repository = GuruRepository(guruDao)
        readAllData = repository.readAllData
    }

    fun addGuru(guru: Guru){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGuru(guru)
        }
    }
    fun updateGuru(guru: Guru){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateGuru(guru)
            repository.updateGuru(guru)
        }
    }
    fun deleteGuru(guru: Guru){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteGuru(guru)
        }
    }
    fun deleteAllGuru() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllGuru()
        }
    }
}