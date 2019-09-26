package labs;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/* Lubna Khalid
 * 9/9/19
 * Professor Sokol
 * Lab 1.4
 */
public class ArrayInfo {

	/* populate a double array, 
	 * the array, with it's count
	 * print: first element
	 * last element
	 * middle element
	 * largest element
	 * smallest element
	 */
	final static int SIZE = 100;
	public static void main(String[] args)throws Exception {
		Scanner in = new Scanner(new File("numbers.txt"));
		double[] nums = new double[SIZE];
		int count = 0;
		count = readData(nums,in);
		System.out.print("The array: {");
		for(int i =0;i<count-1;i++){
			System.out.print(nums[i]+", ");
		}
		System.out.println(nums[count-1]+ "} contains "+count+ " elements");
		System.out.println("The first element of the array is "+ nums[0]);
		System.out.println("The last element of the array is "+ nums[count-1] + " and is at position "+ (count-1));
		int middle = (count-1/2);
		System.out.println("The middle element of the array is "+ nums[middle] + " and is at position "+ (middle));
		findLargest(nums,count);
		findSmallest(nums,count);
		
		
	}
	// finds and prints where the smallest double is
	private static void findSmallest(double[] nums, int count) {
		double min = nums[0];
		int i;
		int pos = 0;
		for(i=1;i<count;i++) {
			if(nums[i]< min) {
				min = nums[i];
				pos = i;
			}
			
		}
		System.out.println("The smallest element of the array is "+ min + " and is at position "+ pos);
	}
	// finds and prints where the largest double is
	private static void findLargest(double[] nums, int count) {
		double max = nums[0];
		int i;
		int pos = 0;
		for(i =1;i<count;i++) {
			if(nums[i]> max) {
				max = nums[i];
				pos = i;
			}
		
		}	
		System.out.println("The largest element of the array is "+ max + " and is at position "+ pos);
	}
	// populates array
	private static int readData(double[] nums, Scanner in) {
		int count = in.nextInt();
		int idx = 0;
		while(idx<count && count<SIZE && in.hasNext()) {
			nums[idx] = in.nextDouble();
			idx++;
		}
		return count;
	}

}
