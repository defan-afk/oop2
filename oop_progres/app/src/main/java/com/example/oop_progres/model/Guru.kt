package com.example.oop_progres.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabel_guru")
data class Guru(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama: String,
    val mapel: String
): Parcelable