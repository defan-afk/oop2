package com.example.oop_progres.repository

import androidx.lifecycle.LiveData
import com.example.oop_progres.guru.GuruDao
import com.example.oop_progres.model.Guru

class GuruRepository(private val guruDao: GuruDao) {

    val readAllData: LiveData<List<Guru>> = guruDao.readAllData()

    suspend fun addGuru(guru: Guru){
        guruDao.addGuru(guru)
    }

    suspend fun updateGuru(guru: Guru){
        guruDao.updateGuru(guru)
    }
    suspend fun deleteGuru(guru: Guru) {
        guruDao.deleteGuru(guru)
    }
    suspend fun deleteAllGuru(){
        guruDao.deleteAllGuru()
    }
}