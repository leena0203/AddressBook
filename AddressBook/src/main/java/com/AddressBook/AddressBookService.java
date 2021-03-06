package com.AddressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBookService {
	public static String FILE = "AddressBook.txt";
	public static String CSVFILE = "AddressBook.csv";
	public static String GSONFILE = "AddressBook.gson";

	public void writeData(Map<String, AddressBook> addressBookMap) {
		StringBuffer employeeBuffer = new StringBuffer();
		for(Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			entry.getValue().getAddressBook().forEach(contact -> {
				String empString = contact.toString().concat("\n");
				employeeBuffer.append(empString);
			});
		}
		try {
			Files.write(Paths.get(FILE), employeeBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readData() {
		try {
			Files.lines(new File(FILE).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UC14 For Writing the data to CSV File
	 * 
	 * @param cityBookMap
	 */
	public void writeDataToCSV(Map<String, AddressBook> addressBookMap) {
		Path path = Paths.get(CSVFILE);
		try {
			FileWriter outputfile = new FileWriter(path.toFile());
			CSVWriter writer = new CSVWriter(outputfile);
			List<String[]> data = new ArrayList<String[]>();
			String[] header = { "First Name", "Last Name", "Address", "City", "State", "ZIP", "Phone Number",
					"Email ID" };
			data.add(header);
			addressBookMap.values().stream().map(entry -> entry.getAddressBook())
					.forEach(entryt -> entryt.forEach(person -> {
						String[] personData = { person.getFirstName(), person.getLastName(), person.getAddress(),
								person.getCity(), person.getState(), Integer.toString(person.getZip()),
								Long.toString(person.getPhoneNumber()), person.getEmailId() };
						data.add(personData);
					}));

			writer.writeAll(data);
			writer.close();
			System.out.println("Data entered successfully to addressbook.csv file.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reading data from the CSV file
	 */
	public void readDataFromCSV() {
		try {
			Reader fileReader = Files.newBufferedReader(Paths.get(CSVFILE));
			@SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(fileReader);
			String[] data;
			while ((data = csvReader.readNext()) != null) {
				for (String cell : data) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeDataGSON(Map<String, AddressBook> addressBookMap) {
		try {
			Gson gson = new Gson();
			FileWriter writer = new FileWriter(GSONFILE);
			addressBookMap.values().stream().map(entry -> entry.getAddressBook())
					.forEach(listEntry -> listEntry.forEach(contact -> {
						String json = gson.toJson(contact);
						try {
							writer.write(json);
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}));
			writer.close();
			System.out.println("Data entered successfully to addressbook.json file.");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void readDataGSON() {
		Gson gson = new Gson();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(GSONFILE));
			JsonStreamParser parser = new JsonStreamParser(bufferedReader);
			while (parser.hasNext()) {
				JsonElement json = parser.next();
				if (json.isJsonObject()) {
					Contact person = gson.fromJson(json, Contact.class);
					System.out.println(person);
				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}