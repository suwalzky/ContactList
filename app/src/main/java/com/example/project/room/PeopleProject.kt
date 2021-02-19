package com.example.project.room;

import androidx.lifecycle.LiveData;
import androidx.room.*;

@Dao
interface PeopleProject {

    @Insert
    fun insert(person: Person)

    @Update
    fun update(person: Person)

    @Delete
    fun delete(person: Person)

    @Query("SELECT * FROM people_table")
    fun getAllPeople(): LiveData<List<Person>>

    @Query("DELETE FROM people_table")
    fun deleteAllRows()
}
