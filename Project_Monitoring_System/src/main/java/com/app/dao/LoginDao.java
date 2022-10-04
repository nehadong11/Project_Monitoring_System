package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Students;

@Repository
public class LoginDao implements LoginDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String registerUser(Students std, Address add) {
		Students student=std;
		student.setAddress(add);
		mgr.persist(student);
		return "Student Registred SuccessFully";
	}

	@Override
	public Admin checkAdminAvailablity() {
		try {
			String jpql="Select a from Admin a";
			Admin admin=mgr.createQuery(jpql, Admin.class).getSingleResult();
			if(admin!=null)
				return admin;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void registerAdmin(Admin admin1) {
		Admin admin=admin1;
		mgr.persist(admin);
	}

	@Override
	public Students verifyStudentLogin(String email, String password) {
		try {
			String jpql="select s from Students s where s.sEmail=:email and s.password=:password";
			Students stdobj= mgr.createQuery(jpql, Students.class).setParameter("email", email).setParameter("password", password).getSingleResult();
			if(stdobj != null)
				return stdobj;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Faculty verifyFacultyLogin(String email, String password) {
		try {
			String jpql="select f from Faculty f where f.email=:email and f.password=:password";
			Faculty fac= mgr.createQuery(jpql, Faculty.class).setParameter("email", email).setParameter("password", password).getSingleResult();
			if(fac != null)
				return fac;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Admin verifyAdminLogin(String email, String password) {
		try {
			String jpql="select a from Admin a where a.email=:email and a.password=:password";
			Admin admin= mgr.createQuery(jpql, Admin.class).setParameter("email", email).setParameter("password", password).getSingleResult();
			if(admin != null)
				return admin;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String registerFaculty(Faculty faculty) {
		Faculty fac=faculty;
		mgr.persist(fac);
		return "Faculty Registred sucessfully, UserName and Password send on Email";
	}

	

	@Override
	public String fetchPassword(String email) {
		try {
			String jpql="Select s from Students s where s.sEmail=:email";
			Students std= mgr.createQuery(jpql, Students.class).setParameter("email", email).getSingleResult();
			String psw=std.getPassword();
			if(std != null)
			return psw;
			return null;
		} catch (Exception e) {
			return null;
		}
		
		
		
	}
	
	
}
