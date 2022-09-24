package com.example.mycontacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mycontacts.R
import com.example.mycontacts.databinding.ActivityAddContactsBinding
import com.example.mycontacts.model.Contact
import com.example.mycontacts.viewmodel.ContactsViewModel

class AddContactsActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddContactsBinding
    val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener {
            validateDetails()
        }
    }

    fun validateDetails(){
        var name=binding.etName.text.toString()
        var email=binding.etEmail.text.toString()
        var phoneNumber=binding.etPhone.text.toString()
        var address=binding.etAddress.text.toString()
        //validate

        val contact=Contact(
            contactId = 0,
            name = name,
            phoneNumber=phoneNumber,
            email = email,
            address=address,
            image = ""
        )
        contactsViewModel.saveContact(contact)
        finish()

    }
}