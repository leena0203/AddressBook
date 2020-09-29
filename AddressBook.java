package address;


import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	private ArrayList<Contact> addressBook= new ArrayList<Contact>();  
	
	public void setAddressBook(ArrayList<Contact> addressBook) {
		this.addressBook = addressBook ;
	}
	public ArrayList <Contact> getAddressBook(){
		return addressBook;
	}
	public void addContact(Contact contactObj) {
		addressBook.add(contactObj);
	}
    public static void main(String[] args) {
    	
    	
    	AddressBook addressBook = new AddressBook();
        System.out.println("Welcome to Address Book");
        Scanner sc = new Scanner(System.in);
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
	    Contact contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);//Created Contact
	addressBook.addContact(contact);//added Contact to the AddressBook
    
}
}
