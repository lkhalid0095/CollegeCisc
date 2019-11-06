package labs;

import java.io.*;
import java.util.*;

public class Name {
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

	public static void main(String [] args) throws Exception {
		Scanner scanner = new Scanner(new File("names.txt"));

		int count = 0;

		Name name = read(scanner);
		while(name != null) {
			System.out.println("name: "+ name.toString());
			System.out.println("formal: " + name.getFormal());
			System.out.println("official: " + name.getOfficial());
			System.out.println("initials: "+ name.getInitials());
			System.out.println();
			count++;
			Name name2 = read(scanner);
			if(name2 != null && name2.equals(name) ) {
				System.out.println("Duplicate name \"" + name.toString() + "\" discovered" );
				name = read(scanner);
				count++;
			} else {
				name = name2;
			}
		}
		System.out.println("---");
		System.out.println(count + " names processed.");
	}
}