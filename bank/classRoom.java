package first.bank;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
public class classRoom {

	public static void main(String[] args) {
		Student s1 = new Student( 11,20,75,"Arun" );
		Student s2 = new Student( 12,22,80,"Chaman" );
		Student s3 = new Student( 13,19,57,"Bhanu" );
		Student s4 = new Student( 14,23,70,"Hement" );
		
		ArrayList<Student> al =new ArrayList<Student>();
		al.add(s4);
		al.add(s1);
		al.add(s3);
		al.add(s2);
		
		
			
		
		
		out.println("-----LIST OF STUDENT BASED ON THEIR MARKS -----");
		Collections.sort(al,new marksComparator());
		for (Student s:al)
			out.println(s.StudentId + " :is student id of MR. " + s.StudentName + " his age is " + s.StudentAge +" and his marks are = " + s.StudentMarks );
        
		out.println("-----LIST OF STUDENT BASED ON THIER ID ----");
		Collections.sort(al,new idComparator());
		for (Student s:al)
			out.println(s.StudentId + " :is student id of MR. " + s.StudentName + " his age is " + s.StudentAge +" and his marks are = " + s.StudentMarks);
          
		out.println("-----LIST OF STUDENT BASED ON THIER AGE ----");
		Collections.sort(al,new ageComparator());
		for (Student s:al)
			out.println(s.StudentId + " :is student id of MR. " + s.StudentName + " his age is " + s.StudentAge +" and his marks are = " + s.StudentMarks);




	}

}
