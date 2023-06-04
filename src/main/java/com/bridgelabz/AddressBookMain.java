package com.bridgelabz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class AddressBookMain extends Collection{
    /*
        map is to maintain the Dictionary of address book name
     */
    public static void addAddressBook() {
        /*
        creating new Address Book And each Address book has Unique name using Console
        */
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter the name of the new Address Book: ");
        addressBook.setAddressBookName(scanner.next());
        // Checking for the key_element 'addressBook.getAddressBookName()'
        if (addressBookMap.containsKey(addressBook.getAddressBookName())) {
            System.out.println("Address Book already exists!!!!");
            return;
        }
        //Mapping AddressBook to String keys
        addressBookMap.put(addressBook.getAddressBookName(),addressBook);
        System.out.println("Address Book Added!!!");
        System.out.println();
        //new address book is added and contact person is added to it by using switch case
        boolean isStatus= true;
        while(isStatus){
            System.out.println("=> To ADD a Contact to this Address Book: PRESS 1");
            System.out.println("=> To Close this Address Book: PRESS 2");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addressBook.addContact();
                    System.out.println(addressBook);
                    System.out.println("Contact Added!!!");
                    System.out.println();
                    break;
                case 2:
                    isStatus=false;
                    break;
                default:
                    System.out.println("Enter a valid choice!!!");
            }
        }
    }
    public static void addContacts() {
        /*
        Contact person in Address Book is added to Address Book name
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the address book you want to add contact:");
        String firstName = scanner.next();
        // Checking for the key_element 'firstName'
        if(addressBookMap.containsKey(firstName)) {
            AddressBook addressBook= addressBookMap.get(firstName);
            addressBook.addContact();
            System.out.println(addressBook);
            System.out.println("Contact Added!!!");
            System.out.println();
        }
        else
            System.out.println("Given Address Book not Found!!!");
    }
    public static void editContacts(){
        /*
            Edit Contact in Address Book is added to Address Book name
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the address book, the contact you want to edit exists:");
        String firstName = scanner.next();
        // Checking for the key_element 'firstName'
        if(addressBookMap.containsKey(firstName)) {
            AddressBook addressBook= addressBookMap.get(firstName);
            System.out.print("Enter the First Name To Edit the Contact : ");
            addressBook.editContact(scanner.next());
        }
        else
            System.out.println("Given Address Book not Found!!!");
    }

    public static void deleteContacts(){
        /*
           Delete Contact in Address Book is added to Address Book name
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the address book, the contact you want to Delete exists:");
        String firstName= scanner.next();
        // Checking for the key_element 'firstName'
        if(addressBookMap.containsKey(firstName)) {
            AddressBook addressBook= addressBookMap.get(firstName);
            System.out.println("Enter the First Name To Delete the Contact : ");
            addressBook.deleteContact(scanner.next());
        }
        else
            System.out.println("Given Address Book not Found!!!");
    }
    public static void displayAddressBook(){
    /*
       Display Contact in Address Book is added to Address Book name
    */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the address book you want to Display:");
        String firstName = scanner.next();
        // Checking for the key_element 'firstName'
        if(addressBookMap.containsKey(firstName)) {
            AddressBook addressBook = addressBookMap.get(firstName);
            System.out.println(addressBook);
        }
        else
            System.out.println("Given Address Book not Found!!!");
    }
    public static void searchByState() {
        /*
        search Person in a State across the multiple AddressBook using stream
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the State Name");
        String stateName = scanner.next();

        List<ContactPerson> stateList = new ArrayList<>();
        addressBookMap.values().stream().forEach(addressBook -> stateList.addAll(addressBook.getContact().stream().filter(
                contact -> contact.getState().equalsIgnoreCase(stateName)).toList()));

        int count = stateList.size();
        System.out.println("The number of person belongs to state :-");
        System.out.println(count+ " Person Detail FOUND belongs to the State " +stateName);
        System.out.println(stateList);

    }
    public static void searchByCity() {
        /*
        search Person in a City across the multiple AddressBook using Stream
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the City Name");
        String cityName = scanner.next();

        List<ContactPerson> cityList = new ArrayList<>();
        addressBookMap.values().stream().forEach(addressBook -> cityList.addAll(addressBook.getContact().stream().filter(
                contact -> contact.getCity().equalsIgnoreCase(cityName)).toList()));

        int count = cityList.size();
        System.out.println("The number of person belongs to city :-");
        System.out.println(count+" Person Detail FOUND belongs to the City " +cityName);
        System.out.println(cityList);
    }
    public static void sortByName() {
        /*
         * UC11: sort the entries in the address book alphabetically by Person’s name
         */
        List<ContactPerson> personName = new ArrayList<>();
        addressBookMap.values().forEach(addressBook -> { personName.addAll(addressBook.getContact().stream().sorted(
                Comparator.comparing(ContactPerson::getFirstName)).toList());
        });
        System.out.println(personName);
    }
    //UC12:
    private static void sortByCity() {
        /*
         * sort the entries in the address book by City.
         */
        List<ContactPerson> cityName = new ArrayList<>();
        addressBookMap.values().forEach(addressBook -> { cityName.addAll(addressBook.getContact().stream().sorted(
                Comparator.comparing(ContactPerson::getCity)).toList());
        });
        System.out.println(cityName);
    }
    public static void sortByState() {
        /*
         * sort the entries in the address book by State.
         */
        List<ContactPerson> stateName = new ArrayList<>();
        addressBookMap.values().forEach(addressBook -> { stateName.addAll(addressBook.getContact().stream().sorted(
                Comparator.comparing(ContactPerson :: getState)).toList());
        });
        System.out.println(stateName);
    }
    public static void sortByZip() {
        /*
         * sort the entries in the address book by Zip.
         */
        List<ContactPerson> zipCode = new ArrayList<>();
        addressBookMap.values().forEach(addressBook -> { zipCode.addAll(addressBook.getContact().stream().sorted(
                Comparator.comparing(ContactPerson :: getZip)).toList());
        });
        System.out.println(zipCode);
    }

    public static void main(String[] args) {
        /*
         * Calling Methods by using Switch Case
         */
        System.out.println(" *** Welcome To ADDRESS BOOK PROGRAM *** ");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("---Address Book---");
            System.out.println("1. Add AddressBook \n2. Add Contact \n3. Edit Contact \n4. Delete Contact \n5. Display Contact \n6. Search By State \n7. Search By City \n8. Sort By Person's Name \n" +
                    "9. Sort By City \n10. Sort By State \n11. Sort By Zip \n12. Write to File \n13. Read from File \n14. write to CSV file \n15. Read from CSV file \n16. Quit");
            System.out.println("Choose any Number : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAddressBook();
                    break;
                case 2:
                    addContacts();
                    break;
                case 3:
                    editContacts();

                    break;
                case 4:
                    deleteContacts();
                    break;
                case 5:
                    displayAddressBook();
                    break;
                case 6:
                    searchByState();
                    break;
                case 7:
                    searchByCity();
                    break;
                case 8:
                    sortByName();
                    break;
                case 9:
                    sortByCity();
                    break;
                case 10:
                    sortByState();
                    break;
                case 11:
                    sortByZip();
                    break;
                case 12:
                    ReadAndWriteFile.writeToFile();
                    break;
                case 13:
                    ReadAndWriteFile.readFromFile();
                    break;
                case 14:
                    ReadAndWriteFile.writeToCSVFile();
                    break;
                case 15:
                    ReadAndWriteFile.readFromCSVFile();
                    break;
                case 16:
                    flag = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}

