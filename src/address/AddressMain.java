package address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressMain {
	public static Map<String,AddressBook> addressBookMap;
	
	public AddressMain() {
		addressBookMap =new HashMap<>();
	}
	public void addAddressBook(String city) {
		AddressBook addaddressBook = new AddressBook();
		addressBookMap.put(city,addaddressBook);
	}
	public ArrayList<Contact> addressBook = new ArrayList<Contact>();
	
	public static void main(String[] args) {
		
		AddressMain addBook = new AddressMain();
		System.out.println("Welcome to Address Book :Enter any key to proceed further");
		Scanner sc = new Scanner(System.in);
		do{	
		sc.nextLine();
			System.out.println("1.Add a new Address Book");
			System.out.println("2.Add a new Contact");
			System.out.println("3.Edit the contact details");
			System.out.println("4.Delete the contact");
			System.out.println("5.View All Contacts");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			//Create new Address book
			case 1:
				System.out.println("Enter the City name to create new Address Book");
		        String City = sc.nextLine();
		        addBook.addAddressBook(City);
				//Add a contact
			case 2:
				System.out.println("Enter the details of person");
				System.out.println("Enter the first name");
				String firstName = sc.nextLine();
				System.out.println("Enter the last name");
				String lastName = sc.nextLine();
				System.out.println("Enter the address");
				String address = sc.nextLine();
				System.out.println("Enter the city name");
				String city = sc.nextLine();
				System.out.println("Enter the state name");
				String state = sc.nextLine();
				System.out.println("Enter the ZIP code");
				int zip = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the phone number");
				long phoneNumber = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter the email");
				String email = sc.nextLine();
				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
				for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
					if(entry.getKey().equalsIgnoreCase(city)) {
						entry.getValue().addContact(contact);
					}
					else {
						System.out.println("The addressbook does not exist, please create addressbook for that city");
					}
				}
				break;
				//Edit a contact
			case 3:
				System.out.println("Enter the contact name");
				String name = sc.nextLine();
				System.out.println("Enter the city name");
				String city1 = sc.nextLine();
				for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
					if(entry.getKey().equalsIgnoreCase(city1)) {
						entry.getValue().editContact(name);
					}
				}
				break;
				//Delete a contact
			case 4:
				System.out.println("Enter the contact name");
				String contactName = sc.nextLine();
				System.out.println("Enter the city name");
				String city11 = sc.nextLine();
				for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
					if(entry.getKey().equalsIgnoreCase(city11)) {
						entry.getValue().deleteContact(contactName);
					}
				}
				break;
				//View all contacts in specific address book
			case 5:
				for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
					System.out.println("All contacts for city"+entry.getKey()+" is: ");
						entry.getValue().displayAllContacts();
				}
			default:
				break;
			}
			System.out.println("Continue:(Y/N)?");
		} while (sc.next().charAt(0) == 'Y');
		System.out.println("Thank You");
		
		}
	}


