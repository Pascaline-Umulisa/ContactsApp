package com.example.mycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.NetworkPolicy
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
        Picasso.get().load(currentContact.image)
            .error(R.drawable.ic_baseline_error_24)
            .placeholder(R.drawable.ic_baseline_person_24)
            .resize(150,150)
            .centerCrop()
//            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.binding.imgContact)
//        holder.imgContact=currentContact.image
//        holder.imgContact.setOnClickListener {
//
//            holder.imgContact.setImageResource(R.drawable.ic_baseline_pan_tool_24)
//        }
//    holder.imgContact.setOnClickListener(View.OnClickListener {
//        holder.imgContact.setImageResource((R.drawable.ic_baseline_pan_tool_24))
//    })
    }


    override fun getItemCount(): Int {
        return contacts.size
}
}
class ContactsViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root)