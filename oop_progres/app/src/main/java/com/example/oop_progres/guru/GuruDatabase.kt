package com.example.oop_progres.guru

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.oop_progres.model.Guru

@Database(entities = [Guru::class], version = 1, exportSchema = false)
abstract class GuruDatabase : RoomDatabase() {

    abstract fun guruDao(): GuruDao

    companion object {
        @Volatile
        private var INSTANCE: GuruDatabase? = null

        fun getDatabase(context: Context): GuruDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GuruDatabase::class.java,
                    "database_guru"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}