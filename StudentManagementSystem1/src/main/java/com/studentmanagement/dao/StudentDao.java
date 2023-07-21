package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.entity.Student;

public interface StudentDao {
	//adding a student
	boolean addStudent(Student s);
	
	//updating the student details
	void updateStudent(Student s);
	
	//get a student based on id
	Student getStudentById(int id);
	
	//get all student details
	List<Student >getAllStudents();
	
	
	//delete student
	void deleteStudent(int id);
	}
