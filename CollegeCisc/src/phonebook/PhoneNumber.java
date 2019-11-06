package phonebook;
import java.io.File;
import java.util.Scanner;

public class PhoneNumber {

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
	//prints phone number with it's different characteristics.
	public static void main(String [] args) throws Exception {
		Scanner scanner = new Scanner(new File("numbers.txt"));

		int count = 0;

		PhoneNumber number = read(scanner);
		while(number != null) {
			System.out.println("phone number: "+ number.toString());
			System.out.println("area code: " + number.getAreaCode());
			System.out.println("exchange: " + number.getExchange());
			System.out.println("line number: "+ number.getLineNumber());
			System.out.println("is toll free: " + number.isTollFree());
			System.out.println();
			count++;
			PhoneNumber num2 = read(scanner);
			if(num2 != null && num2.equals(number) ) {
				System.out.println("Duplicate phone number \"" + number.toString() + "\" discovered" );
				number = read(scanner);
				count++;
			} else {
				number = num2;
			}
		}
		System.out.println("---");
		System.out.println(count + " phone numbers processed.");
	}


}
