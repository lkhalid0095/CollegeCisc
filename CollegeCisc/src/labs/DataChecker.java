package labs;

import java.util.Scanner;
import java.io.*;

public class DataChecker {

	final static int SIZE = 100;

	// prints out the number of integers in a line 
	public static void main(String[] args)throws Exception {
		
		Scanner fileScanner = new Scanner(new File("numbers.txt"));
		Scanner lineScanner = new Scanner(System.in);
		int[] arr = new int[SIZE];
		int idx = 0;
		int error = 0;
		int valid = 0;
		while (fileScanner.hasNextLine()) {
		try {
			String line = fileScanner.nextLine();        
			lineScanner = new Scanner(line); 
			int count = 0;
			if(lineScanner.hasNext()) {
				arr[0] = lineScanner.nextInt();
				count++;
			}//end if statement
			double average = 0;
			double sum = 0;
			while(lineScanner.hasNext()) {
				arr[count] = lineScanner.nextInt();
				count++;
			} //end of while loop
			for(int i = 1; i<count;i++) {
				sum += arr[i];
				average = sum/(count-1);
			} // end of for loop
			idx++;
			validAverage(idx,count,arr);
			valid++;
			System.out.println("The average of the values on line " +idx + " is "+ average);
		}catch(Exception e) {
				System.out.println(e.getMessage());
				error++;
			}//end of catch block
		} // end of while
		System.out.println();
		System.out.println("There were "+ valid+ " valid lines of data");
		System.out.println("There were "+ error + " corrupt lines of data");

	}

	// validates the input
	private static void validAverage(int idx, int count, int[] arr) throws Exception {
		double header = arr[0];
		if(header == 0) {
			throw new Exception("*** Error (line "+ idx + "): Header value of 0 - average can't be taken");
		}//
		else if(header < 0) {
			throw new Exception("*** Error (line "+ idx + "): Corrupt line - negative header value");
		}
		else if(count == 0) {
			throw new Exception("*** Error (line "+ idx + "): Line is empty - average can't be taken");
		}
		else if((count-1) < header) {
			throw new Exception("*** Error (line "+ idx + "): Corrupt line - fewer values than header");
		}
		else if((count-1) > header) {
			throw new Exception("*** Error (line "+ idx + "): Corrupt line - extra values on line");
		}

	}




}
