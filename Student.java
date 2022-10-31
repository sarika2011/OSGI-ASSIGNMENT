package com.mysite.core.services;

import java.util.ArrayList;
import com.mysite.core.services.impl.StudentImpl;

//import com.mysite.core.services.impl.StudentImpl;

public interface Student {
	void addStudent(String name, int id, double marks);
	void deleteStudent(int id);
	boolean isStudentPassed(int id);
	String getStudent(int id);
	void getAllStudents();
	boolean isClassLimitReached(ArrayList<StudentImpl> l);
	double getPassingMarks();
}
