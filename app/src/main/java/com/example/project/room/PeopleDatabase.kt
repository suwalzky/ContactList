package com.example.project.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 3)
abstract class PeopleDatabase : RoomDatabase() {

    abstract fun peopleProject(): PeopleProject

    companion object {
        private var instance: PeopleDatabase? = null
        fun getInstance(context: Context): PeopleDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    PeopleDatabase::class.java,
                    "people_table"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return instance
        }

        fun deleteInstanceOfDatabase() {
            instance = null
        }
    }
}