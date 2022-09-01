/* This is a java program for print all numbers which is divisable by Five */

package first.bank;

import java.util.stream.Stream;// This class is import because we use Stream in our program  
import static java.lang.System.*; // this class is import for avoid System from System.out.println 

public class divisbleFive {

	public static void main(String[] args) {
		//Stream.iterate is use for iterate the elements
		//filter is use for apply the particular conditions
		//limit is use for give the limit to the program
		//forEach is use for print the elements
		Stream.iterate(1,i->i+1).filter(i->i%5==0).limit(20).forEach(out::println);
		

	}

}
