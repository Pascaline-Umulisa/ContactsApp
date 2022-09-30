package com.example.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.databinding.ContactListItemBinding
import com.example.mycontacts.model.Contact
import com.example.mycontacts.ui.ViewContactActivity
import com.squareup.picasso.Picasso

class ContactsAdapter(var contacts:List<Contact>):
    RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding= ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ContactsViewHolder(binding)
}

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
       var currentContact=contacts.get(position)
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvNumber.text=currentContact.phoneNumber
        holder.binding.tvEmail.text=currentContact.email
        holder.binding.tvAddress.text=currentContact.address
//        Picasso.get().load(currentContact.image)
//            .error(R.drawable.ic_baseline_error_24)
//            .placeholder(R.drawable.ic_baseline_person_24)
//            .resize(150,150)
//            .centerCrop()
////            .networkPolicy(NetworkPolicy.OFFLINE)
//            .into(holder.binding.imgContact)
        val context=holder.itemView.context
       holder.binding.imgContact.setOnClickListener {
           Toast.makeText(context,"You have clicked on ${currentContact.name}'s image",Toast.LENGTH_SHORT).show()
       }
        holder.binding.cvContact.setOnClickListener {
            val intent=Intent(context, ViewContactActivity::class.java)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("NUMBER",currentContact.phoneNumber)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("ADDRESS",currentContact.address)
//            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return contacts.size
}
}
class ContactsViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root)