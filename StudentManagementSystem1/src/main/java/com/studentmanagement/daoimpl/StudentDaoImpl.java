package com.studentmanagement.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.entity.Student;
import com.studentmanagement.exception.StudentException;
import com.studentmanagement.utility.Helper;

public class StudentDaoImpl implements StudentDao{
	
	Session session=Helper.makeConnection();

	@Override
	public boolean addStudent(Student s) {
		boolean status=false;
		try
		{
			//creating a session to create connection
			//Session session=help.makeConnection();
			//begin transaction
			session.beginTransaction();
			int id=(int) session.save(s);
			session.getTransaction().commit();
			
			//checking status of adding student
			if(id>0)
				status=true;
			else
			{
				status=false;
				throw new StudentException("student is not added");
			}
				
			
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception ocured");
			
		} 
		catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void updateStudent(Student s) {
		try
		{
		//creating connection
		//Session session=help.makeConnection();
		session.beginTransaction();
		session.saveOrUpdate(s);
		session.getTransaction().commit();
		}
	catch(HibernateException e)
	{
		System.out.println("Hibernate exception ocured");
	}
		
		
	}

	@Override
	public Student getStudentById(int id) {
		Student s=null;
		//get student by id
		try  //try with resource statement
		{
			session.beginTransaction();
			 s=session.get(Student.class,id); //get() to fetch student details based on primary key
			 session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception ocured");
		}
	
		return s;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		List<Student> ls=null;
		try
		{
		//creating connection
		
		session.beginTransaction();
		ls=session.createQuery("from Student").list(); //HQL Query (like select * from Student)
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception ocured");
		}
		
		return ls;
	}

	
	@Override
	public void deleteStudent(int id) {
		Student s=null;
		try
		{
			session.beginTransaction();
			s=session.get(Student.class,id);
			session.delete(s);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			System.out.println("Hibernate exception ocured");
		}
		
	}

}
