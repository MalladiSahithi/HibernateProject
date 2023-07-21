package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.entity.Student;

public interface StudentService {
	//adding a student
		boolean addNewStudent(Student s);
		
		//updating the student details
		void updateNewStudent(Student s);
		
		//get a student based on id
		Student getNewStudentById(int id);
		
		//get all student details
		List<Student >getAllNewStudents();
		
		
		//delete student
		void deleteNewStudent(int id);

}
