package com.example.oop_progres.repository

import androidx.lifecycle.LiveData
import com.example.oop_progres.model.Siswa
import com.example.oop_progres.siswa.SiswaDao

class SiswaRepository(private val siswaDao: SiswaDao) {

    val readDataSiswa: LiveData<List<Siswa>> = siswaDao.readDataSiswa()

    suspend fun addSiswa(siswa: Siswa){
        siswaDao.addSiswa(siswa)
    }

    suspend fun updateSiswa(siswa: Siswa){
        siswaDao.updateSiswa(siswa)
    }
    suspend fun deleteSiswa(siswa: Siswa) {
        siswaDao.deleteSiswa(siswa)
    }
    suspend fun deleteAllSiswa(){
        siswaDao.deleteAllSiswa()
    }

}