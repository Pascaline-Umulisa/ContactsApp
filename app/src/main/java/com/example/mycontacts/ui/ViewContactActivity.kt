package com.example.mycontacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycontacts.R
import com.example.mycontacts.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
        getClicklisteners()
    }
    fun getClicklisteners(){
        binding.imgBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    fun getExtras(){
        val extras=intent.extras
        binding.tvContactname.text=extras?.getString("NAME","")
        binding.tvEmailaddress.text=extras?.getString("EMAIL","")
        binding.tvLocation.text=extras?.getString("ADDRESS","")
        binding.tvPhonenumber.text=extras?.getString("NUMBER","")
//        val image=extras?.getString("IMAGE","")
//        Picasso.get().load(image)
//            .placeholder(R.drawable.ic_baseline_person_24)
//            .resize(300,300)
//            .centerCrop()
////            .networkPolicy(NetworkPolicy.OFFLINE)
//            .into(binding.ivContact)
//        Toast.makeText(this,"$name:$email",Toast.LENGTH_LONG).show()
    }
}