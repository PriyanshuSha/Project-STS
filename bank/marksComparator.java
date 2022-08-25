package first.bank;

import java.util.Comparator;

public class marksComparator implements Comparator <Student> {
	public int compare(Student s1, Student s2) {
		if (s1.StudentMarks == s2.StudentMarks)
		return 0;
		if (s1.StudentMarks > s2.StudentMarks)
			return 1;
		else
			return -1;
	}

}
