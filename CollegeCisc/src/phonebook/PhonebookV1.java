package phonebook;
import java.io.*;
import java.util.Scanner;

/** class Phonebook gives us the ability to look up a phone number */
public class PhonebookV1 {

	/** main declares 2 parallel arrays, calls read method, loops to search
	 */
	public static void main(String[] args) throws IOException  {

		final int SIZE=100;
		String[] firstNames = new String[SIZE];
		String[] lastNames = new String[SIZE];
		String[] numbers = new String[SIZE];
		int lookup = 0;
		int revLookUp = 0;

		int numElts = read("phonebook.txt",firstNames,lastNames,numbers);
		Scanner keyboard = new Scanner(System.in);
		System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");

		String input = keyboard.next();
		while (!input.equals("q")) {
			if(input.equals("l")) {
				lookupPrompt(keyboard,input,firstNames,lastNames,numbers,numElts);
				System.out.print("\nlookup, reverse-lookup, quit (l/r/q)? ");
				input = keyboard.next();
				lookup++;

			} else if(input.equals("r")) {

				revPrompt(keyboard,input,firstNames,lastNames,numbers,numElts);
				System.out.print("\nlookup, reverse-lookup, quit (l/r/q)? ");
				input = keyboard.next();
				revLookUp++;
			} 
		}
		System.out.println("\n"+lookup + " lookups performed");
		System.out.println(revLookUp + " reverse lookups performed");
		keyboard.close();
	}



	/**
	 * prompts the user to type in their phone number, and searches for the first and last name.
	 * @param keyboard
	 * @param input
	 * @param firstNames
	 * @param lastNames
	 * @param numbers
	 * @param numElts
	 */
	private static void revPrompt(Scanner keyboard, String input, String[] firstNames, String[] lastNames, String[] numbers,
			int numElts) {
		System.out.print("phone number (nnn-nnn-nnnn)? ");
		String phoneNum = keyboard.next();
		String contactName = revLookup(firstNames, lastNames, numbers, numElts, phoneNum);
		if (contactName.equals("")){
			System.out.println("-- Phone number not found");
		} else {
			System.out.println(phoneNum +" belongs to " + contactName);
		}

	}



	/**
	 * prompts the user, if they clicked 'l' asking for their first/last name. 
	 * @param keyboard
	 * @param input 
	 * @param firstNames
	 * @param lastNames
	 * @param numbers
	 * @param numElts
	 */
	private static void lookupPrompt(Scanner keyboard, String input, String[] firstNames, String[] lastNames, String[] numbers,	int numElts) {

		System.out.print("last name? ");
		String lastName = keyboard.next();
		System.out.print("first name? ");
		String firstName = keyboard.next();
		String number = lookup(firstNames, lastNames, numbers, numElts, firstName,lastName);
		if (number.equals("")) {
			System.out.println("-- Name not found");

		}

		else {
			System.out.println(firstName +" " + lastName + "'s phone number is " + number);

		}
	}



	/** read method reads from a file into the names and numbers arrays
   @param filename  name of file with input
   @param names this is an empty array to be filled
   @param numbers this is an empty array to be filled
	 * @param numbers2 
   @return int returns the number of data elements read in (IMPORTANT)
	 */
	public static int read(String filename, String[] firstNames, String[] lastNames, String[] numbers) throws IOException  {
		int count=0; // this is the number of lines read in  
		Scanner scanner = new Scanner(new File(filename));
		// read until EOF
		while(scanner.hasNext()) {
			if (count >= firstNames.length) {
				System.out.println("Phonebook capacity exceeded - increase size of underlying array");
				System.exit(1);
			}
			lastNames[count] = scanner.next();
			firstNames[count] = scanner.next();
			numbers[count]=scanner.next();
			count++;
		} 
		scanner.close();
		return count;

	}

	/** lookup performs a linear search to find the name.
   @param firstNames
   @param lastNames
	 * @param numbers
   @param size
   @param name 
   @return String representing the phone number of the name searched
	 */
	public static String lookup(String[] firstNames, String[] lastNames, String[] numbers, int size, String firstName, String lastName)  {
		for (int i=0; i<size; i++)
			if (firstNames[i].equals(firstName) && lastNames[i].equals(lastName))
				return numbers[i];
		// if fall out, not found
		return "";
	}

	/** TODO reverse lookup performs a linear search to find the name based on the phone number.
	 * 
	 * @param names
	 * @param numbers
	 * @param numElts
	 * @param phoneNum
	 * @return String representing the name of the phone number searched.
	 */
	private static String revLookup(String[] firstNames, String[] lastNames, String[] numbers, int numElts, String phoneNum) {
		String name = "";
		for (int i=0; i<numElts; i++)
			if (numbers[i].equals(phoneNum)) {
				name = lastNames[i] + ", " +firstNames[i];
				return name;
			}
		// if fall out, not found
		return "";	
	}
}


