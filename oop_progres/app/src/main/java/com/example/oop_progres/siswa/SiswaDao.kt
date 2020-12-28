package com.example.oop_progres.siswa

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.oop_progres.model.Siswa

@Dao
interface SiswaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSiswa(siswa: Siswa)

    @Update
    suspend fun updateSiswa(siswa: Siswa)

    @Delete
    suspend fun deleteSiswa(siswa: Siswa)

    @Query("DELETE FROM tabel_siswa")
    suspend fun deleteAllSiswa()

    @Query("SELECT * FROM tabel_siswa ORDER BY id ASC")
    fun readDataSiswa(): LiveData<List<Siswa>>
}