package phonebook;

import java.io.File;
import java.util.Scanner;

public class PhonebookEntry {

	private Name name;
	private PhoneNumber phoneNumber;
	
	// 2 args constructor. instantiate name and phone number 
	public PhonebookEntry(Name name, PhoneNumber phoneNumber) {
	
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	//returns the instance variable name
	public Name getName() {
		return name;
	}
	
	//returns the instance variable phoneNumber
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	
	//prints the name and the phone number calling
	public void call() {
		System.out.print("Dialing ");
		if(phoneNumber.isTollFree())
			System.out.print("(toll-free) ");
		System.out.println(name.toString()+": "+ phoneNumber.toString());
	}
	//checks if the entries are equal
	public boolean equals(PhonebookEntry obj) {
		
		return name.equals(obj.name) && phoneNumber.equals(obj.phoneNumber);
		
	}
	//prints the entry as a string
	public String toString() {
		return name.toString() + phoneNumber.toString();
		
	}
	// reads a file as a phonebook entry
	public static PhonebookEntry read(Scanner in) {
		if (!in.hasNext()) 
			return null;
		Name name = new Name(in.next(),in.next());
		PhoneNumber phoneNumber = new PhoneNumber(in.next());
		return new PhonebookEntry(name, phoneNumber);
	}
	// 
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("phonebook.txt"));

		int count = 0;

		PhonebookEntry entry = read(scanner);
		while(entry != null) {
			System.out.println("phone book entry: "+ entry.getName() + ": "+entry.getPhoneNumber());
			entry.call();
			System.out.println();
			count++;
			PhonebookEntry entry2 = read(scanner);
			if(entry2!= null && entry.getName().equals(entry2.getName()) && !(entry.getPhoneNumber().equals(entry2.getPhoneNumber()))) {
				System.out.println("Warning duplicate name encountered \""+ entry2.getName() + ": "+entry2.getPhoneNumber()+ "\" discovered");
			}
			
			if(entry2 != null && entry2.equals(entry) ) {
				System.out.println("Duplicate phone book entry \"" + entry.getName() + ": "+entry.getPhoneNumber() + "\" discovered" );
				entry = read(scanner);
				count++;
			} else {
				entry = entry2;
			}
		}
		System.out.println("---");
		System.out.println(count + " phonebook entries processed.");
	
	}

}
