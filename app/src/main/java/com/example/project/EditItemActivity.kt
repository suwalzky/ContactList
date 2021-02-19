package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project.room.Person
import com.example.project.viewmodel.PeopleViewModel
import kotlinx.android.synthetic.main.activity_edit.*

class EditItemActivity() : IncludeToolbarActivity() {

    private lateinit var viewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewModel::class.java)

        insertButtonEdit.setOnClickListener {
            val firstName = firstNameTextEdit.text.toString()
            val lastName = lastNameTextEdit.text.toString()
            val telephoneNumber = telNumberTextEdit.text.toString()

            if (firstName.isNullOrEmpty() && lastName.isNullOrEmpty() && telephoneNumber.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Brak danych do zapisania!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val person = Person(firstName, lastName, telephoneNumber)
                viewModel.updatePerson(person)
                Toast.makeText(this, "Kontakt został zapisany", Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(applicationContext, ShowListActivity::class.java))
        }

        removeSingleEdit.setOnClickListener {
            val firstName = firstNameTextEdit.text.toString()
            val lastName = lastNameTextEdit.text.toString()
            val telephoneNumber = telNumberTextEdit.text.toString()

            val person = Person(firstName, lastName, telephoneNumber)
            viewModel.deletePerson(person)
            Toast.makeText(this, "Pojedyńczy kontakt został usunięty", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, ShowListActivity::class.java))
        }
    }
}