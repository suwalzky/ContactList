package com.example.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.room.Person

class Adapter(
    private val listOfPeople: List<Person>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from((parent.context))
        val row = layoutInflater.inflate(R.layout.person_row, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.firstNameTextView.text = listOfPeople[position].firstName
        holder.lastNameTextView.text = listOfPeople[position].lastName
        holder.telNumberTextView.text = listOfPeople[position].telNumber
    }

    override fun getItemCount(): Int {
        return listOfPeople.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        val firstNameTextView: TextView = view.findViewById(R.id.row_firstName)
        val lastNameTextView: TextView = view.findViewById(R.id.row_lastName)
        val telNumberTextView: TextView = view.findViewById(R.id.row_telNumber)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}