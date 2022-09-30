package com.example.mycontacts.repository

import androidx.lifecycle.LiveData
import com.example.mycontacts.MyContacts
import com.example.mycontacts.database.ContactsDb
import com.example.mycontacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ContactsRepository {
    var database=ContactsDb.getDatabase(MyContacts.appContext)

    suspend fun saveContact(contact: Contact){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }

    fun getContactById(contactId:Int):LiveData<Contact>{
        return database.contactDao().getContactById(contactId)
    }

    fun getAllContacts(): LiveData<List<Contact>> {
        return database.contactDao().getAllContacts()
    }
}