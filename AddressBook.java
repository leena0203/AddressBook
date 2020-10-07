package address;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	public ArrayList<Contact> addressBook = new ArrayList<Contact>();

	public void setAddressBook(ArrayList<Contact> addressBook) {
		this.addressBook = addressBook;
	}

	public ArrayList<Contact> getAddressBook() {
		return addressBook;
	}

	public String city;

	public AddressBook() {
		this.city = city;
	}

	public void addContact(Contact contactObj) {
		addressBook.add(contactObj);
	}

	public void editContact(String name) {
		Scanner sc = new Scanner(System.in);
		String x = "";
		for (Contact contact : addressBook) {
			x = contact.getFirstName() + contact.getLastName();
			if (name.equals(x)) {
				System.out.println("1.Change the address");
				System.out.println("2.Change the city");
				System.out.println("3.Change the state");
				System.out.println("4.Change the ZIP code");
				System.out.println("5.Change the phone number");
				System.out.println("6.Change the Email id");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter new address");
					String address = sc.nextLine();
					contact.setAddress(address);
					break;
				case 2:
					System.out.println("Enter new city");
					String city = sc.nextLine();
					contact.setCity(city);
					break;
				case 3:
					System.out.println("Enter new state");
					String state = sc.nextLine();
					contact.setAddress(state);
					break;
				case 4:
					System.out.println("Enter new ZIP code");
					int zip = sc.nextInt();
					contact.setZip(zip);
					sc.nextLine();
					break;
				case 5:
					System.out.println("Enter new phone number");
					long phone = sc.nextLong();
					sc.nextLine();
					contact.setPhoneNumber(phone);
					break;
				case 6:
					System.out.println("Enter new Email id");
					String email = sc.nextLine();
					contact.setEmailId(email);
					break;
				}
			}
		}

	}

	public void deleteContact(String name) {
		String x = "";
		for (Contact contact : addressBook) {
			x = contact.getFirstName() + contact.getLastName();
			if (name.equals(x)) {
				addressBook.remove(contact);
			}
		}
	}

	public void displayAllContacts() {

		for (Contact contact : addressBook) {
			System.out.println("First Name : " + contact.getFirstName() + "Last Name : " + contact.getLastName()
					+ " Address : " + contact.getAddress() + " City : " + contact.getCity() + " State : "
					+ contact.getState() + " ZIP : " + contact.getZip() + " Phone Number : " + contact.getPhoneNumber()
					+ " Email ID : " + contact.getEmailId() + "\n");
		}
	}

}
