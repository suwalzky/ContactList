package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project.room.Person
import com.example.project.viewmodel.PeopleViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : IncludeToolbarActivity() {

    private lateinit var viewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewModel::class.java)

        insertButton.setOnClickListener {
            val firstName = firstNameText.text.toString()
            val lastName = lastNameText.text.toString()
            val telephoneNumber = telNumberText.text.toString()

            if (firstName.isNullOrEmpty() && lastName.isNullOrEmpty() && telephoneNumber.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Brak danych do zapisania!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val person = Person(firstName, lastName, telephoneNumber)
                viewModel.insertPerson(person)
            }
        }

        showListBT.setOnClickListener {
            val intent = Intent(applicationContext, ShowListActivity::class.java)
            startActivity(intent)
        }
    }
}