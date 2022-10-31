package com.mysite.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Deactivate;
//import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import com.mysite.core.services.Student;


@Component(service = Student.class, immediate = true)
@Designate(ocd = StudentConfiguration.class)
public class StudentImpl implements Student {
   
    Scanner sc = new Scanner(System.in);
    
	int b;
	double m;
	
	private String sname;
	private int sid;
	private double smarks;
	
	List<StudentImpl>l=new ArrayList<StudentImpl>();
	
	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public double getSmarks() {
		return smarks;
	}


	public void setSmarks(double smarks) {
		this.smarks = smarks;
	}
	
	
	public StudentImpl(String sname, int sid, double smarks) {
		super();
		this.sname = sname;
		this.sid = sid;
		this.smarks = smarks;
	}
    
	

	@Activate
	public void activate(StudentConfiguration config) {
		b = config.no_of_students_allowed();
		m = config.marks_required_to_pass();
	}


	@Override
	public void addStudent(String sname, int sid, double smarks) {
		System.out.println("Enter name: ");
		sname = sc.nextLine();
		System.out.println("Enter id: ");
		sid = sc.nextInt();
		System.out.println("Enter marks: ");
		smarks = sc.nextDouble();
		StudentImpl obj = new StudentImpl(sname,sid,smarks);
		l.add(obj);
		System.out.println("Student added successfully...");
	}


	@Override
	public void deleteStudent(int id) {
		int di=-1;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getSid()==id)
			{
				di=i;
				break;
			}
		}
		if(di==-1)
		{
			System.out.println("Enter valid id!!!");
		}
		else
		{
			l.remove(di);
			System.out.println("Student removed successfully with id: "+id);
		}
	}


	@Override
	public boolean isStudentPassed(int id) {
		int flag=0;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getSid()==id && l.get(i).getSmarks()>m)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Enter valid id!!!");
			return false;
		}
		else
		{
			return true;
		}
	}


	@Override
	public String getStudent(int id) {
		String s="";
		int flag=0;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getSid()==id)
			{
				flag=1;
				s+=l.get(i).getSname();
				break;
			}
		}
		if(flag==0)
		{
			return "Enter valid id!!!";
		}
		else
		{
			return s;
		}
	}


	@Override
	public void getAllStudents() {
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getSname()+" "+l.get(i).getSid()+" "+l.get(i).getSmarks());
		}
	}


	@Override
	public boolean isClassLimitReached(ArrayList<StudentImpl> l) {
		if(l.size()>b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public double getPassingMarks() {
		
		return m;
	}
	
}
