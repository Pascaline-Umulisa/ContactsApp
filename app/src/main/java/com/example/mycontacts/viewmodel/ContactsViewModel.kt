package com.example.mycontacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycontacts.model.Contact
import com.example.mycontacts.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    var contactsRepository=ContactsRepository()
    lateinit var contactLiveData:LiveData<Contact>
    lateinit var contactsLiveData: LiveData<List<Contact>>
    fun saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
    fun getAllContacts(){
        contactsLiveData= contactsRepository.getAllContacts()

    }
    fun fetchContactById(contactId: Int){
        contactLiveData=contactsRepository.getContactById(contactId)
    }
}