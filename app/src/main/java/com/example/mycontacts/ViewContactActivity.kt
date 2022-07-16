package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ViewContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)
        getExtras()
    }
    fun getExtras(){
        val extras=intent.extras
        val name=extras?.getString("NAME","")
        val email=extras?.getString("EMAIL","")

        Toast.makeText(this,"$name:$email",Toast.LENGTH_LONG).show()
    }
}