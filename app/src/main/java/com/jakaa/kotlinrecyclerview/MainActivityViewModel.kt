package com.jakaa.kotlinrecyclerview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.logging.Handler

private const val TAG = "MainActivityViewModel"

class MainActivityViewModel : ViewModel(){
    private val contactsLiveData:MutableLiveData<MutableList<Contact>>
    private val isReshfreshingLiveData: MutableLiveData<Boolean>

    init {
        Log.i(TAG, "init")
        contactsLiveData = MutableLiveData()
        contactsLiveData.value = createContacts()
        isReshfreshingLiveData = MutableLiveData()
        isReshfreshingLiveData.value = false
    }
    fun getContacts(): LiveData<MutableList<Contact>>{
        return contactsLiveData
    }
    fun getIsRefreshing(): LiveData<Boolean>{
        return isReshfreshingLiveData
    }

    fun fetchNewContact() {
        Log.i(TAG, "fetchNewContact")
        isReshfreshingLiveData.value = true
        android.os.Handler().postDelayed(Runnable {
            contactsLiveData.value
            //contacts?.add(0, Contact("Julius Campbell", 52))
            //contactsLiveData.value = contacts
            //isReshfreshingLiveData = false
        },1_000)
        // add the new contact
        // Indicate that we're in "refreshing" state

    }
    private fun createContacts(): MutableList<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150){
            contacts.add(Contact("Person #$i", i))
        }
        return contacts
    }


}












































