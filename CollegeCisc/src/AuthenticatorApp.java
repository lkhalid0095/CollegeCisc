import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class Authenticator {

	final static int SIZE = 100;
	private User[] users = new User[SIZE];
	int size;
	
	// arg - constructor
	public Authenticator(String filename) throws Exception {
		Scanner in = new Scanner(new File(filename));
		size = 0;
		while(in.hasNext() && size < SIZE) {
			users[size] = User.read(in);
			System.out.println(users[size]);
			size++;
		}
		
	}
	public void authenticate(String name, String password) throws Exception{
		boolean found = false;
		for(int i = 0;i <size;i++) {
			if((users[i].getUsername()).equals(name)) {
				found = true;
				if(!users[i].verifyPassword(password)) {
					throw new Exception("Invalid password - hint: "+ users[i].getHint());
				}
				
			System.out.println(found);
			} 
			
		}
		return;
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
                            //e.printStackTrace();
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
class User {
    User(String username, String password, String hint) {
            this.username = username;
            this.password = password;
            this.hint = hint;
    }
    String getUsername() {return username;}
    String getHint() {return hint;}
    boolean verifyPassword(String password) {return this.password.equals(password);}
    public String toString() {return "User " + username;}
    public static User read(Scanner scanner) {
            if (!scanner.hasNext()) return null;
            String username = scanner.next();
            String password = scanner.next();
            String hint = scanner.next();
            return new User(username, password, hint);
    }
    private String username, password;
    private String hint;
}