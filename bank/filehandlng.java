/* This is java program to create a new text file in which we take input from user 
 @ Priyanshu  */


package first.bank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class filehandlng {

	public static void main(String[] args) throws IOException {
		
		Scanner ps=new Scanner (System.in);
		
		File f2=new File ("c:readingdata.text");
		System.out.println("Enter data into the file ");
		String data =ps.nextLine();
		FileWriter fw=new FileWriter(f2);
		fw.write(data);
		System.out.println(f2.getName()+" is created successfully");
		fw.close();
		ps.close();

	}

}
