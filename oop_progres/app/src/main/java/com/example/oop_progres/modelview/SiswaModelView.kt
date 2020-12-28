package com.example.oop_progres.modelview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.oop_progres.model.Siswa
import com.example.oop_progres.repository.SiswaRepository
import com.example.oop_progres.siswa.SiswaDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SiswaModelView(application: Application): AndroidViewModel(application) {

    val readDataSiswa: LiveData<List<Siswa>>
    private val repository: SiswaRepository

    init {
        val siswaDao = SiswaDatabase.getDatabase(
            application
        ).siswaDao()
        repository = SiswaRepository(siswaDao)
        readDataSiswa = repository.readDataSiswa
    }

    fun addSiswa(siswa: Siswa){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSiswa(siswa)
        }
    }
    fun updateSiswa(siswa: Siswa){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateSiswa(siswa)
            repository.updateSiswa(siswa)
        }
    }
    fun deleteSiswa(siswa: Siswa){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteSiswa(siswa)
        }
    }
    fun deleteAllSiswa() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllSiswa()
        }
    }
}