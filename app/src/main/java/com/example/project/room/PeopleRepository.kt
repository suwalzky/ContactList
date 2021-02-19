package com.example.project.room

import android.app.Application
import androidx.lifecycle.LiveData;
import kotlinx.coroutines.*

class PeopleRepository (application: Application){

    private var peopleProject: PeopleProject

    init {
        val database = PeopleDatabase
            .getInstance(application.applicationContext)

        peopleProject = database!!.peopleProject()
    }

    fun insertPerson(person: Person) =
        CoroutineScope(Dispatchers.IO).launch{
            peopleProject.insert(person)
        }

    fun updatePerson (person: Person) =
        CoroutineScope(Dispatchers.IO).launch{
            peopleProject.update(person)
        }

    fun deletePerson (person: Person) =
        CoroutineScope(Dispatchers.IO).launch{
            peopleProject.delete(person)
        }

    fun getAllPeopleAsync(): Deferred<LiveData<List<Person>>> =
        CoroutineScope(Dispatchers.IO).async{
            peopleProject.getAllPeople()
        }

    fun deleteAllRows () =
        CoroutineScope(Dispatchers.IO).launch{
            peopleProject.deleteAllRows()
        }
}