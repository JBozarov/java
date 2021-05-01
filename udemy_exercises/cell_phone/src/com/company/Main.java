package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CellPhone cellPhone = new CellPhone("123 456 7890");

    public static void main(String[] args) {

        boolean quite = false;
        startPhone();
        printActions();

        while(!quite){
            System.out.println("Enter actions: ");
            int action = Integer.parseInt(scanner.nextLine());

            switch (action) {
                case 0 :
                    System.out.println("System is shutting down");
                    quite = true;
                    break;
                case 1 :
                    cellPhone.printContacts();
                    break;
                case 2 :
                    addNewContact();
                    break;
                case 3 :
                    updateContact();
                    break;
                case 4 :
                    removeContact();
                    break;
                case 5 :
                    searchContact();
                    break;
                case 6 :
                    printActions();
                    break;

            }
        }
    }

    // Starting phone:
    public static void startPhone(){
        System.out.println("Starting your phone ... ");
    }

    // printing actions
    public static void printActions() {
        System.out.println("Available actions");
        System.out.println("0 - to shutdown ");
        System.out.println("1 - to print contacts");
        System.out.println("2 - to add new contact");
        System.out.println("3 - to update");
        System.out.println("4 - to remove existing contact");
        System.out.println("5 - to check if contact exists");
        System.out.println("6 - print a list of available actions");
        System.out.println("Please choose action: ");
    }

    // adding new contact
    public static void addNewContact() {
        System.out.println("Enter new contact name ");
        String name = scanner.nextLine();
        System.out.println("Enter new contact phone number ");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, phone);
        cellPhone.addNewContact(contact);

    }

    // update contact
    public static void updateContact() {
        System.out.println("Enter old contact name you want to update:  ");



        String oldName = scanner.nextLine();
        int foundPosition = cellPhone.findContact(oldName);
        if (foundPosition>=0) {
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            cellPhone.updateContact(foundPosition, newName);

        }
        else {
            System.out.println("Contact doesn't exists");
        }
    }

    // remove contact
    public static void removeContact() {
        System.out.println("Enter name of the contact you want to remove: ");
        String name = scanner.nextLine();
        int foundPosition = cellPhone.findContact(name);
        if (foundPosition>=0) {
            cellPhone.removeContact(foundPosition);
        }
        else {
            System.out.println("Contact not found! ");
        }
    }

    // search contact
    public static void searchContact() {
        System.out.println("Enter contact name");
        String name = scanner.nextLine();
        cellPhone.searchContact(name);
    }
}
