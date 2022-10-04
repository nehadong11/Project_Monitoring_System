package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LoginDaoInterface;
import com.app.pojos.Address;
import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Students;

@Service
@Transactional
public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginDaoInterface loginDao;

	@Override
	public String registerUser(Students std, Address add) {
		return loginDao.registerUser(std, add);
	}

	@Override
	public Admin checkAdminAvailablity() {
		return loginDao.checkAdminAvailablity();
	}

	@Override
	public void registerAdmin(Admin admin1) {
		loginDao.registerAdmin(admin1);
		
	}

	@Override
	public Students verifyStudentLogin(String email, String password) {
		return loginDao.verifyStudentLogin(email, password);
	}

	@Override
	public Faculty verifyFacultyLogin(String email, String password) {
		return loginDao.verifyFacultyLogin(email, password);
	}

	@Override
	public Admin verifyAdminLogin(String email, String password) {
		return loginDao.verifyAdminLogin(email, password);
	}

	@Override
	public String registerFaculty(Faculty faculty) {
		return loginDao.registerFaculty(faculty);
	}

	@Override
	public String fetchPassword(String email) {
		// TODO Auto-generated method stub
		return loginDao.fetchPassword(email);
	}
}
