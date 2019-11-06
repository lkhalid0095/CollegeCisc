package phonebook;
import java.io.*;
import java.util.Scanner;

/** class Phonebook gives us the ability to look up a phone number */
public class Phonebook {

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


