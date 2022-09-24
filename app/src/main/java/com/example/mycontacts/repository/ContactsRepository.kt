package com.example.mycontacts.repository

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
}