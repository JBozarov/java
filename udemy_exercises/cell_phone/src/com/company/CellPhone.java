package com.company;

import java.util.ArrayList;

class CellPhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public CellPhone(String myNumber) {
        super();
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>(); // initializing array list
    }

    // Printing contacts
    public void printContacts() {
        System.out.println("Contacts list is: " + this.myContact.size());
        for ( int i = 0; i<this.myContact.size(); i++ ) {
            System.out.println( (i+1 ) + ". " + this.myContact.get(i).getName() + " " + this.myContact.get(i).getPhoneNumber());
        }
    }

//     Adding new constact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already in file");
            return false;
        }
        myContact.add(contact);
        System.out.println("Contact is added ");
        return true;
    }

    // Finding contact
    private int findContact(Contact contact) {
        return this.myContact.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i<this.myContact.size(); i++ ) {
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Updating existing contact name
    public boolean updateContact (int foundPosition, String newName) {
        String phoneNumber = this.myContact.get(foundPosition).getPhoneNumber();
        Contact newContact = new Contact(newName, phoneNumber);
        this.myContact.set(foundPosition, newContact);
        System.out.println("Contact successfully updated! ");
        return true;
    }

    // Removing contact
    public void removeContact(int position) {
        this.myContact.remove(position);
        System.out.println("Successfully removed! ");
    }

    // Searching contact
    public void searchContact(String name) {
        boolean flag = true;
        for (int i = 0; i<this.myContact.size(); i++ ) {
            if (this.myContact.get(i).getName().equals(name)) {
                System.out.println("Found " + this.myContact.get(i).getName() + " " + this.myContact.get(i).getPhoneNumber());
                flag = false;
            }

        }
        if (flag) {
            System.out.println(name + " is not found");
        }
    }

}

