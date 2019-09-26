package labs;

/* Lubna Khalid
 * Lab 1
 * 9/9/19
 * Professor Sokol
 * Lab 1.1
 */
import java.util.*;
public class InfoOf3{
//ask digits, read number, compare input.
 public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("first number? ");
        int first= in.nextInt();
//      System.out.println(first);
        System.out.print("second number? ");
        int second = in.nextInt();
//      System.out.println(second);
        System.out.print("third number? ");
        int third = in.nextInt(); 
//      System.out.println(third);
        boolean allEqual= allAreEqual(first,second,third);
        System.out.println("allAreEqual: " +allEqual);
        boolean twoEqual = twoAreEqual(first,second,third);
        System.out.println("twoAreEqual: "+twoEqual);
        boolean noneEqual= noneAreEqual(first,second,third);
        System.out.println("noneAreEqual: "+noneEqual);
        boolean ascending = areAscending(first,second,third);
        System.out.println("areAscending: " +ascending);
        boolean descending = areDescending(first,second,third);
        System.out.println("areDescending: "+descending);
        boolean onlyAsc = strictlyAscending(first,second,third);
        System.out.println("strictlyAscending: "+ onlyAsc);
        boolean onlyDesc = strictlyDescending(first,second,third);
        System.out.print("strictlyDescending: "+onlyDesc);
        in.close();
 }
//if nums are equals
  public static boolean allAreEqual(int a, int b, int c){
        if(a == b & b== c){
          return true;
        }
          return false;
       }   
//if two of the nums are equal, not all of them.
  public static boolean twoAreEqual(int a,int b,int c){ 
        if(allAreEqual(a,b,c)){
          return false;
        }else if(a == b || a ==c || b == c){ 
          return true;
        }   
    
         return false;
}
//if none of them are equal
  public static boolean noneAreEqual(int a,int b,int c){
        if(a != b && b!=c & a!=c){
          return true;
        } else
        return false;
}
//if the nums are  ascending, can be same
  public static boolean areAscending(int a,int b,int c){
        if(a <= b && b<=c)
          return true;

         return false;
}
//if nums are descending, can be equal to each other.
  public static boolean areDescending(int a,int b,int c){
        if(a >= b && b >= c)
         return true;

        return false;
}
//numbers only ascend.
  public static boolean strictlyAscending(int a,int b,int c){
        if(a<b && b<c){
         return true;
        }
        return false;
}
//numbers only descend.
  public static boolean strictlyDescending(int a,int b,int c){
        if(a > b && b>c){
         return true;
        }
        return false;
}
}
