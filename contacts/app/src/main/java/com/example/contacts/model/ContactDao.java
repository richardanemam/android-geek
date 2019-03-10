package com.example.contacts.model;

import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    private static ContactDao contactDao = new ContactDao();
    private List<ContactModel> contactList = new ArrayList<>();

    private ContactDao() {
    }

    public static ContactDao getInstance() {
        return contactDao;
    }

    public void addContact(ContactModel contact) {
        contactList.add(contact);
    }

    public List<ContactModel> getContactList() {
        return contactList;
    }

}
