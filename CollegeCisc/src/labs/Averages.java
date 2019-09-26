package labs;

/* Lubna Khalid
 * Lab 1
 * 9/9/19
 * Professor Sokol
 * Lab 1.2 
 */
import java.util.Scanner;
import java.io.*;

public class Averages {

	final static int SIZE = 100;
	// read data, and process the averages
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("numbers.txt"));
		int[] nums = new int[SIZE];
		int count = 0;
		int num = 0;


		while(num < SIZE && in.hasNext()) {
			count = readData(nums,in);
			
			System.out.print("The average of the " + nums[0]+ " integers ");
				for(int i=1; i< count;i++) {
					System.out.print(nums[i]+ " ");
				}
			System.out.println("is " +findAverage(nums,count));
			num++;
		}
		System.out.println(num + " sets of numbers processed.");
	}
	// finds the average of the array
	private static double findAverage(int[] nums, int count) {
		
		double average = 0;
		double sum = 0;
		for(int i= 1; i< count; i++) {
			sum += nums[i];
			
		}
		average = sum/nums[0];
		return average;
	}
	// populate reads from a file to an array, returns the count.
	private static int readData(int[] nums, Scanner in) {
		int count = 0;
		int idx = 0;
		idx = in.nextInt();
		nums[0] = idx;
		count++;
		while(count <= idx && in.hasNextLine()) {
			nums[count] = in.nextInt(); 
			count++;
		}
		return count;
	}

}
