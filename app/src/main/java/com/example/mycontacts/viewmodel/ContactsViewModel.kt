package com.example.mycontacts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycontacts.model.Contact
import com.example.mycontacts.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    var contactsRepository=ContactsRepository()

    fun saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
}