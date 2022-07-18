package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }

    fun displayContacts(){
        var contac1=Contact("Pascaline Umulisa ","+250 786933554","pascaline@gmail.com","616 Korongo road","https://images.unsplash.com/photo-1589156280159-27698a70f29e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contac2=Contact("Elizabeth Ampurira ","+250 786933554","paccy@gmail.com","616 Korongo road","https://images.unsplash.com/photo-1572224384995-f9529873f379?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contac3=Contact("Verite Umuhoza Natete","+250 786933554","paccy@gmail.com","616 Korongo road","https://images.unsplash.com/photo-1539701938214-0d9736e1c16b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contac4=Contact("Lucy Kalimi","+250 786933554","liz@gmail.com","616 Korongo road","https://images.unsplaaaaash.com/photo-1583994009785-37ec30bf9342?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contac5=Contact("Chili Mercy Kemboi","+250 786933554","verite@gmail.com","616 Korongo road","https://images.unsplash.com/photo-1530785602389-07594beb8b73?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YmxhY2slMjBnaXJsc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
        var contac6=Contact("Gikundiro Liliane ","+250 786933554","kayi@gmail.com","616 Korongo road","https://images.unsplash.com/photo-1533143562855-d018b598571a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8YmxhY2slMjBnaXJsc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
        var contac7=Contact("Nadine Sangwa","+250 786933554","nadine@gmail.com","616 Korongo road","https://images.unsplash.com/photo-1593880223042-744ce9a4b58f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGJsYWNrJTIwZ2lybHN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contactList= listOf(contac1,contac2,contac3,contac4,contac5,contac6,contac7)

        var contactsAdapter=ContactsAdapter(contactList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }
}