package com.example.project

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class IncludeToolbarActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.backToHome -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                true
            }
            R.id.showListBT -> {
                startActivity(Intent(applicationContext, ShowListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}