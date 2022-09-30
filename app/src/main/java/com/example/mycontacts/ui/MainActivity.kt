package com.example.mycontacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontacts.ContactsAdapter
import com.example.mycontacts.databinding.ActivityMainBinding
import com.example.mycontacts.model.Contact
import com.example.mycontacts.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsViewModel.getAllContacts()
    }

    override fun onResume() {
        super.onResume()
        binding.fabAddContact.setOnClickListener {
            startActivity(Intent(this,AddContactsActivity::class.java))
        }

        contactsViewModel.contactsLiveData.observe(this, Observer { contacts->
            displayContacts(contacts)
        })
    }

    fun displayContacts(contacts:List<Contact>){
        var contactsAdapter= ContactsAdapter(contacts)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }
}