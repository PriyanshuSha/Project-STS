package first.bank;

import java.util.Comparator;

public class idComparator implements Comparator <Student> {
	public int compare(Student s1, Student s2) {
		if (s1.StudentId == s2.StudentId)
		return 0;
		if (s1.StudentId > s2.StudentId)
			return 1;
		else
			return -1;
			
	}

}
