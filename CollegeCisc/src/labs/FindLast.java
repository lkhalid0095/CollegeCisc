package labs;

import java.io.File;
/* Lubna Khalid
 * Lab 1
 * 9/9/19
 * Professor Sokol
 * Lab 1.3
 */
import java.util.Scanner;
public class FindLast {

	final static int SIZE = 100;
	/* reads from a file, asks user for a value,
	 searches for the value, 
	 find the last position
	 print appropriate message.
	 */
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		int count = 0;
		int[] nums = new int[SIZE];
		count = readData(nums);
		int pos = 0;
		int idx =0;
		System.out.print("Enter a number: ");
		
		while(keyboard.hasNext()){
			idx = keyboard.nextInt();
			pos = findLast(nums, count, idx);
			if(pos == -1) {
				System.out.println(idx + " does not appear in the file");
				System.out.print("Enter a number: ");
			}else{
				System.out.println(idx + " last appears in the file at position " + pos);
				System.out.print("Enter a number: ");
			}
		}
	}
	// finds the last time an integer occured in an array
	private static int findLast(int[] nums, int count, int idx) {
		int pos = -1;
		int temp =0;
		for (int i =0;i<count;i++) {
			if(idx == nums[i]) {
				temp = i+1;
				if(temp>pos) {
					pos = temp;
				}
			}
					
		}			
			
		
		return pos;
	}
	// populates data
	private static int readData(int[] nums) throws Exception {
		int count = 0;
		Scanner in = new Scanner(new File("numbers.txt"));
		while(count<SIZE && in.hasNextInt()) {
			nums[count] = in.nextInt();
			count++;
		}
		in.close();
		return count;
		
	}

}
