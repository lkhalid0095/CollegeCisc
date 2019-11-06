package labs;

import java.io.File;
import java.util.Scanner;
class User {
	
	private String username;
	private String password;
	private String hint;
	// initialize variables
	public User(String name, String password,String hint) {
		username = name;
		this.password = password;
		this.hint = hint;
	}
	// accessors to username and password
	public String getUsername() {
		return username;
	}
	public String getHint() {
		return hint;
	}
	// verifies password, kind of like equals method
	public boolean verifyPassword(String str) {
		return password.equals(str);
	}
	//returns username of a user
	public String toString() {
		return "User " + username;
	}
	// read a User from file
	public static User read(Scanner in) {
		if(!in.hasNext()) {
			return null;
		}//
		String username = in.next();
		String password = in.next();
		String hint = in.next();
		return new User(username,password,hint);
	}
}//end of class
