/* This is a java program for print the sum of all even numbers which is present in the ArrayList*/

package first.bank;

import java.util.ArrayList;       //This class is import for using ArrayList
import static java.lang.System.*;  // This class is import for avoid System from System.out.println 
public class evenNumbers {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<Integer>();// Here we make a ArrayList which type is Integer
		al.add(10); //Here we add elements into the ArrayLis
		al.add(13); //Here we add elements into the ArrayList
		al.add(20); //Here we add elements into the ArrayList
		al.add(27); //Here we add elements into the ArrayList
		al.add(9);  //Here we add elements into the ArrayList
		al.add(30); //Here we add elements into the ArrayList
		
		int res=al.stream().filter(i->i%2==0).reduce(0,(i,j)->i+j); // reduce method is use for print the result
		out.println("Here is the sum of even numbers :"+res); // Here we store our result
		

	}

}
