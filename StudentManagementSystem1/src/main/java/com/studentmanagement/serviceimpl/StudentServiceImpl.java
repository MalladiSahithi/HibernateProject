package com.studentmanagement.serviceimpl;

import java.util.List;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.daoimpl.StudentDaoImpl;
import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;

public class StudentServiceImpl implements StudentService {
	//create an object for StudentDao and use its methods here
	StudentDao st=new StudentDaoImpl();

	@Override
	public boolean addNewStudent(Student s) {
		if(st.addStudent(s))
			return true;
		else
			return false;
	}

	@Override
	public void updateNewStudent(Student s) {
		st.updateStudent(s);

	}

	@Override
	public Student getNewStudentById(int id) {
		Student s=null;
		 s=st.getStudentById(id);
		return s;
	}

	@Override
	public List<Student> getAllNewStudents() {
		
		List<Student> ls=null;
		ls=st.getAllStudents();
		return  ls;
	}

	@Override
	public void deleteNewStudent(int id) {
		st.deleteStudent(id);

	}

}
