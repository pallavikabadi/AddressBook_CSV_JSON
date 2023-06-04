package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook extends Collection{
    public ArrayList<ContactPerson> getContact() {
        return contact;
    }
    public void setContact(ArrayList<ContactPerson> contact){
        this.contact = contact;
    }

    private String addressBookName;

    public AddressBook(String addressBookName) {

        this.addressBookName = addressBookName;
    }
    public AddressBook() {

    }
    public String getAddressBookName() {
        return addressBookName;
    }
    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }
    @Override
    public String toString() {
        return "AddressBook{" +
                "contacts=" + contact +
                ", addressBookName='" + addressBookName + '\'' +
                "}\n";
    }
    public void addContact() {

        System.out.println("Enter the Details of Contact Person :-");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        String firstName = scanner.next();

        List<ContactPerson> duplicateName = contact.stream().filter(contactPerson -> contactPerson.getFirstName().equals(firstName)).toList();
        if (!(duplicateName.isEmpty())){
            System.out.println("Contacts of Given First Name is already Exists !!");
            System.out.println();
            addContact();
            return;
        }
/*
  * Creating Contacts for each person by Using Scanner method
  *  add multiple contacts to address book
 */
        ContactPerson contactPerson = new ContactPerson();
//        System.out.print("Enter the First Name : ");
        contactPerson.setFirstName(firstName);
        System.out.print("Enter the Last Name : ");
        contactPerson.setLastName(scanner.next());
        System.out.print("Enter the Address : ");
        contactPerson.setAddress(scanner.next());
        System.out.print("Enter the City : ");
        contactPerson.setCity(scanner.next());
        System.out.print("Enter the State : ");
        contactPerson.setState(scanner.next());
        System.out.print("Enter the Zip Code : ");
        contactPerson.setZip(scanner.next());
        System.out.print("Enter the PhoneNumber : ");
        contactPerson.setPhoneNumber(scanner.next());
        System.out.print("Enter the Email id : ");
        contactPerson.setEmail(scanner.next());
        contact.add(contactPerson);
    }
    public void editContact(String searchFirstName) {
        /*
         * To Edit Existing Contact Person by Searching their First Name
         * By using if Loop, details of the existing contact will print
         * By using Switch Case, Updates the existing contact Person
         */
        Scanner scanner = new Scanner(System.in);
        boolean isFound = false;
        for (ContactPerson contactPerson : contact) {
            String firstName = contactPerson.getFirstName();
            if (firstName.equals(searchFirstName)) {
                System.out.println("Contact Details of "+searchFirstName+" :-");
                System.out.println("1. First Name \n2. Last Name \n3. Address \n4. City \n5. State \n6. Zip Code \n7. Phone Number \n8. Email Id \n");
                System.out.println("Enter your Choice which you want to Edit :- ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        System.out.println("Update the First Name :");
                        String updatedFirstName = scanner.next();
                        contactPerson.setFirstName(updatedFirstName);
                        System.out.println("First Name is UPDATED");
                        display();
                        break;
                    case 2:
                        System.out.println("Update the Last Name :");
                        String updatedLastName = scanner.next();
                        contactPerson.setLastName(updatedLastName);
                        System.out.println("Last Name is UPDATED");
                        display();
                        break;
                    case 3:
                        System.out.println("Update the Address :");
                        String updatedAddress = scanner.next();
                        contactPerson.setAddress(updatedAddress);
                        System.out.println("Address is UPDATED");
                        display();
                        break;
                    case 4:
                        System.out.println("Update the City :");
                        String updatedCity = scanner.next();
                        contactPerson.setCity(updatedCity);
                        System.out.println("City is UPDATED");
                        display();
                        break;
                    case 5:
                        System.out.println("Update the State :");
                        String updatedState = scanner.next();
                        contactPerson.setState(updatedState);
                        System.out.println("State is UPDATED");
                        display();
                        break;
                    case 6:
                        System.out.println("Update the Zip :");
                        String updatedZip = scanner.next();
                        contactPerson.setZip(updatedZip);
                        System.out.println("Zip Code is UPDATED");
                        display();
                        break;
                    case 7:
                        System.out.println("Update the Phone Number :");
                        String updatedPhoneNumber = scanner.next();
                        contactPerson.setPhoneNumber(updatedPhoneNumber);
                        System.out.println("Phone Number is UPDATED");
                        display();
                        break;
                    case 8:
                        System.out.println("Update the Email Id :");
                        String updatedEmailId = scanner.next();
                        contactPerson.setEmail(updatedEmailId);
                        System.out.println("Email Id is UPDATED");
                        display();
                        break;
                    default:
                        System.out.println("INVALID CHOICE");
                        break;
                }
                isFound = true;
                break;
            }
        }
        if (!isFound)
            System.out.println("No Record Found!");
    }
    public void deleteContact(String searchFirstName) {
        /*
         * To Delete the Contact Person by Searching their First Name
         */
        boolean isFound = false;
        for (ContactPerson contactPerson : contact) {
            if (contactPerson.getFirstName().equals(searchFirstName)) {
                contact.remove(contactPerson);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("Contact of " + searchFirstName + " is Deleted Successfully.");
        } else {
            System.out.println("Contact of " + searchFirstName + " is Not Found.");
        }
    }
    public void display () {
        // To print the ArrayList of Contact
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the address book to Display:");
        String name = scanner.next();
        if(addressBookMap.containsKey(name)) {
            AddressBook contact = addressBookMap.get(name);
            System.out.println(contact);
        }
        else
            System.out.println("Given Address Book NOT FOUND\n");
    }
}

