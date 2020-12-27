package com.example.oop_progres.guru

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.oop_progres.model.Guru

@Dao
interface GuruDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGuru(guru: Guru)

    @Update
    suspend fun updateGuru(guru: Guru)

    @Delete
    suspend fun deleteGuru(guru: Guru)

    @Query("DELETE FROM tabel_guru")
    suspend fun deleteAllGuru()

    @Query("SELECT * FROM tabel_guru ORDER BY id ASC")
    fun readAllData(): LiveData<List<Guru>>

}