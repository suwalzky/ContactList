package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapters.Adapter
import com.example.project.extension.setDivider
import com.example.project.room.Person
import com.example.project.viewmodel.PeopleViewModel
import kotlinx.android.synthetic.main.activity_show_list.*


class ShowListActivity : IncludeToolbarActivity(), Adapter.OnItemClickListener {

    private lateinit var viewModel: PeopleViewModel
    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listOfPeople: LiveData<List<Person>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        viewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setDivider(R.drawable.recycler_view_divider)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        listOfPeople = viewModel.getAllPeople()
        listOfPeople.observe(this, Observer {
            if (it.isNotEmpty()) {
                adapter = Adapter(it, this)
                recyclerView.adapter = adapter
            }
        })

        clearDataButton.setOnClickListener {
            viewModel.deleteAllRows()
            Toast.makeText(this, "Wszystkie kontakty zostały usunięte.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Przechodzisz do edycji kontaktu", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext, EditItemActivity::class.java))
    }
}