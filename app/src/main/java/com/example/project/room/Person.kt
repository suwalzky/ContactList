package com.example.project.room;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people_table")
data class Person(
    var firstName: String,
    var lastName: String,
    var telNumber: String
) {
    @PrimaryKey(autoGenerate = true)
    var user_id: Int = 0
}