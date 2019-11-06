package labs;

import java.io.File;
import java.util.Scanner;

class Authenticator {

	final static int SIZE = 100;
	private User[] users = new User[SIZE];
	int size;
	
	// arg - constructor
	public Authenticator(String filename) throws Exception {
		Scanner in = new Scanner(new File(filename));
		int count = 0;
		while(in.hasNext() && count < SIZE) {
			users[count] = User.read(in);
			count++;
		}
		size = count;
		
	}
	public void authenticate(String name, String password) throws Exception {
		for(int i = 0; i < size;i++) {
			if(!(name.equals(users[size].getUsername()))){
				throw new Exception("--- Username not found ---");
			}
			else if(!(users[size].verifyPassword(password))){
				throw new Exception("*** Invalid password - hint: "+ users[size].getHint());
			}
			
		}
	}
	
}//end of class
class AuthenticatorApp {
    public static void main(String [] args) throws Exception {
            Authenticator authenticator = new Authenticator("users.txt");
            Scanner keyboard = new Scanner(System.in);
            int failCount = 0;
            boolean done = false;
            while (!done) {
                    try {
                            System.out.print("username? ");
                            String username = keyboard.next();
                            System.out.print("password? ");
                            String password = keyboard.next();
                            authenticator.authenticate(username, password);
                            done = true;
                    } catch (Exception e) {
                            System.out.println("*** " + e.getMessage());
                            failCount++;
                            if (failCount == 3) {
                                    System.out.println("Too many failed attempts... please try again later");
                                    System.exit(0);
                            }
                    }
            }
            System.out.println("Welcome to the system");
    }
}