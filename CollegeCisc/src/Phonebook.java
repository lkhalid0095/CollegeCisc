import java.io.*;
import java.util.*;

class Phonebook {

	/** main uses PhonebookEntry, which uses Name and PhoneNumber objects 
	 * to read and lookup entries
	 */
	final static int SIZE=100;

	public static void main(String[] args) throws IOException  {
		try {

			String filename = "phonebook.txt";
			Scanner in = new Scanner(new File(filename));
			PhonebookEntry[] entry = new PhonebookEntry[SIZE];
			int numElts = read(entry,in);
			int lookup = 0;
			int revLookUp = 0;

			Scanner keyboard = new Scanner(System.in);
			System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");

			String input = keyboard.next();
			while (!input.equals("q")) {
				if(input.equals("l")) {
					lookupPrompt(keyboard,input,entry,numElts);
					System.out.print("\nlookup, reverse-lookup, quit (l/r/q)? ");
					input = keyboard.next();
					lookup++;

				} else if(input.equals("r")) {

					revPrompt(keyboard,input,entry,numElts);
					System.out.print("\nlookup, reverse-lookup, quit (l/r/q)? ");
					input = keyboard.next();
					revLookUp++;
				} 
			}
			System.out.println("\n"+lookup + " lookups performed");
			System.out.println(revLookUp + " reverse lookups performed");
			keyboard.close();
		}catch(FileNotFoundException s) {
			System.out.println("*** IOException *** phonebook.text (No such file or directory)\n" + 
					"");
		}catch(Exception s) {
			System.out.println("*** Exception *** Phonebook capacity exceeded - increase size of underlying array");
		}
	}

	// TODO Auto-generated method stub
	private static void revPrompt(Scanner keyboard, String input, PhonebookEntry[] entry, int numElts) {
		System.out.print("phone number (nnn-nnn-nnnn)? ");
		PhoneNumber phoneNum = new PhoneNumber(keyboard.next());
		Name name = new Name("");
		Name contactName = revLookup(entry, numElts, phoneNum);
		if (contactName.equals(name)){
			System.out.println("-- Phone number not found");
		} else {
			System.out.println(phoneNum.toString() +" belongs to " + contactName);
		}

	}

	// reverse lookup performs a linear search to find the name based on the phone number.
	private static Name revLookup(PhonebookEntry[] entry, int numElts, PhoneNumber phoneNum) {
		Name name = new Name("");
		for (int i=0; i<numElts; i++)
			if (entry[i].getPhoneNumber().equals(phoneNum)) {
				name = entry[i].getName();

			}
		return name;
	}

	// prompts the user, if they clicked 'l' asking for their first/last name. 
	private static void lookupPrompt(Scanner keyboard, String input, PhonebookEntry[] entry, int numElts) {

		System.out.print("last name? ");
		String lastName = keyboard.next();
		System.out.print("first name? ");
		String firstName = keyboard.next();
		Name name = new Name(lastName, firstName);
		PhoneNumber num2 = new PhoneNumber("");
		PhoneNumber number = lookup(entry, numElts, name);

		if (number.equals(num2)) {
			System.out.println("-- Name not found");

		}

		else {
			System.out.println(name.getFormal() + "'s phone number is " + number);

		}
	}

	// lookup performs a linear search to find the name.
	private static PhoneNumber lookup(PhonebookEntry[] entry, int numElts, Name name) {
		PhoneNumber number = new PhoneNumber("");
		for (int i=0; i<numElts; i++)
			if (entry[i].getName().equals(name)) 
				number = entry[i].getPhoneNumber();
		return number;
	}

	// populates the phone book entry array.  
	private static int read(PhonebookEntry[] entry, Scanner in) {
		int count = 0;
		while(in.hasNext()) {
			entry[count] = PhonebookEntry.read(in);
			count++;
		} 

		return count;
	}
}


class PhonebookEntry {

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

}
class PhoneNumber {

	private String number;

	// one arg constructor. Initialize number.
	public PhoneNumber(String number) {
		this.number = number;
	}
	//gets the first three number.
	public String getAreaCode() {
		return number.substring(1,4);
	}
	//returns the middle three digits
	public String getExchange() {
		return number.substring(5, 8);
	}
	//returns the last four digits
	public String getLineNumber() {
		return number.substring(9,13);
	}
	//checks if the number is toll-free
	public boolean isTollFree(){
		if(number.substring(1,2).equals("8")) {
			return true;
		}
		return false;
	}
	//reads a phoneNumber 
	public static PhoneNumber read(Scanner in) {
		if (!in.hasNext()) {
			return null;
		}
		String number = in.next();
		return new PhoneNumber(number);
	}
	//checks if the numbers are equal 
	public boolean equals(PhoneNumber obj) {
		return number.equals(obj.number);
	}
	//returns the number as a string
	public String toString() {
		return number;
	}
}

class Name {
	public Name(String last, String first) {
		this.last = last;
		this.first = first;
	}
	public Name(String first) {this("", first);}

	public String getFormal() {return first + " " + last;}
	public String getOfficial() {return last + ", " + first;}

	public boolean equals(Name other) {return first.equals(other.first) && last .equals(other.last);}

	public String toString() {return first + " " + last;}

	public static Name read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		String last = scanner.next();
		String first = scanner.next();
		return new Name(last, first);
	}
	public String getInitials() {
		return first.substring(0,1) + "." + last.substring(0,1) + ".";
	}

	private String first, last;

}