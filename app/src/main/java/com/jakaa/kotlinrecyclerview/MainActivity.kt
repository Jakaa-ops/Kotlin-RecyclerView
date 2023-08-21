package com.jakaa.kotlinrecyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")

        val rvContacts = findViewById<RecyclerView>(R.id.rvContacts)
       // rvContacts.setBackgroundColor(Color.RED)

       val contacts = mutableListOf<Contact>()
        val contactAdapter = ContactAdapter(this, contacts)
        rvContacts.adapter = contactAdapter
        rvContacts.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        model.getContacts().observe(this, Observer { contactsSnapshot->
            //Update to UI
            Log.i(TAG, "Received contacts from view model")
            contacts.clear()
            contacts.addAll(contactsSnapshot)
            contactAdapter.notifyDataSetChanged()
        })

        model.getIsRefreshing().observe(this, Observer { isRefreshing->
            //swipeContainer.isRefreshing = isRefreshing
        })

        var swipeContainer = findViewById<SwipeRefreshLayout>(R.id.swipeContainer)
        swipeContainer.setOnRefreshListener{
            //Show the refreshing UI and fetch new data
            model.fetchNewContact()
        }
    }


}








































































