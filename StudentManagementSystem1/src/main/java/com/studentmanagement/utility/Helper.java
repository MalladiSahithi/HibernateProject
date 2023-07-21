package com.studentmanagement.utility;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.serviceimpl.StudentServiceImpl;

public class Helper {
	static StudentService studentService=new StudentServiceImpl();
	public static Session makeConnection()
	{
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	}
	
	
	public static void menu()
	{
		try
		{
		int id;
		Scanner sc=new Scanner(System.in);
		int choice;
		Student student=new Student();
		
		do
		{
		//menu driven
		System.out.println("Enter the choice to perform operation");
		System.out.println("1.Add a new Student");
		System.out.println("2.Delete a Student");
		System.out.println("3.Update a  Student");
		System.out.println("4.Get all Students");
		System.out.println("5.Get a specific student details");
		System.out.println("6.Exit");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1: //to add a new student
				System.out.println("Enter the name");
				student.setName(sc.next());
				System.out.println("Enter the course");
				student.setCourse(sc.next());
				if(studentService.addNewStudent(student))
					System.out.println("----------student details inserted successfully using Hibernate-----------");
				else
					System.out.println("--------------------Student details not inserted--------------");
				break;
				
		case 2://to delete a student
				System.out.println("Enter the student id to be deleted");
				id=sc.nextInt();
				studentService.deleteNewStudent(id);
				System.out.println("-------------student deleted using hibernate-------");
				break;
				
		case 3://updating a student
				System.out.println("Enter the student id to be updated");
				id=sc.nextInt();
				Student student1=new Student();
				 student1=studentService.getNewStudentById(id);
				//System.out.println("current student name is "+student.getName());
				//System.out.println("current student course name is "+student.getCourse());
				System.out.println("update name :choose 1");
				System.out.println("update course :choose 2");
				choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:System.out.println("enter the name to be updated");
						student1.setName(sc.next());
						studentService.updateNewStudent(student1);
						break;
				case 2:System.out.println("enter the course to be updated");
						student1.setCourse(sc.next());
						studentService.updateNewStudent(student1);
						break;
				
				}
				break;
		case 4://display all students
				List<Student> ls=studentService.getAllNewStudents();
				for(Student st:ls)
				{
					System.out.println("Name:"+st.getName());
					System.out.println("Course:"+st.getCourse());
				}
				break;
				
		case 5://to get a student detail
				System.out.println("enter the student id to be displayed");
				id=sc.nextInt();
				student=studentService.getNewStudentById(id);
				System.out.println("Name:"+student.getName());
				System.out.println("Course:"+student.getCourse());
				break;
				
		case 6:System.exit(0);
		
		default:System.out.println("Wrong input enetred!please check");
				break;
				
		}
		}
		while(choice==7);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
}
