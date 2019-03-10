package com.example.contacts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.contacts.R;
import com.example.contacts.model.ContactModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactsViewHolder> {

    private Context context;
    private List<ContactModel> contactList;
    private onItemClickListener listener;

    public interface onItemClickListener{
        void onClick(View itemView, int position);
    }

    public ContactAdapter(Context context, List<ContactModel> contactList,
                          onItemClickListener listener){
        this.context = context;
        this.contactList = contactList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ContactAdapter.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                int viewType) {
        View itemView = LayoutInflater.from(this.context)
                .inflate(R.layout.item_contact, parent, false);

        return new ContactsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        ContactModel contact = this.contactList.get(position);
        holder.name.setText(contact.getNome());
        holder.email.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.contactList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public TextView email;


        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name_contact);
            email = itemView.findViewById(R.id.tv_email_contact);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
