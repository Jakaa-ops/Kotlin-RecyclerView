package com.jakaa.kotlinrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val context: Context, private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val TAG = "ContactAdapter"

    // Usually involve inflating a layout from xml and returning the holder-THIS IS EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    // Return the total count of item in the list-THIS IS NOT EXPENSIVE
    override fun getItemCount(): Int {
        return contacts.size
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
        val ivProfile = itemView.findViewById<ImageView>(R.id.ivProfile)


        fun bind(contact: Contact) {
            Log.i(TAG, "onBindViewHolder at position $position")
            tvName.text = contact.name
            tvAge.text = "Age: ${contact.age}"
            Glide.with(context).load(contact.imageUral).into(ivProfile)
        }

    }
}




































