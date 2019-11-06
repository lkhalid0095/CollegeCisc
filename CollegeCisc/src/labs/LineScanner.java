package labs;

import java.util.Scanner;
import java.io.*;

public class LineScanner {

	final static int SIZE = 100;

	// prints out the number of integers in a line 
	public static void main(String[] args)throws Exception {

		Scanner fileScanner = new Scanner(new File("numbers.txt"));
		Scanner lineScanner = new Scanner(System.in);
		int[] arr = new int[SIZE];
		int idx = 0;
		while (fileScanner.hasNextLine()) {            
			String line = fileScanner.nextLine();        
			lineScanner = new Scanner(line); 
			int count = read(lineScanner,arr);
			idx++;
			System.out.println("There are "+count + " numbers on line " + idx);
			}
		
		
		fileScanner.close();
		lineScanner.close();
		}

	// populates the line
	private static int read(Scanner lineScanner, int[] arr) {
		int count = 0;
		while(lineScanner.hasNext()) {
			arr[count] = lineScanner.nextInt();
			count++;
		}
		return count;
	}
		

}
