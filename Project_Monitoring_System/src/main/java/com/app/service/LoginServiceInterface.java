package com.app.service;

import com.app.pojos.Address;
import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Students;

public interface LoginServiceInterface {

	String registerUser(Students std, Address add);

	Admin checkAdminAvailablity();

	void registerAdmin(Admin admin1);

	Students verifyStudentLogin(String email, String password);

	Faculty verifyFacultyLogin(String email, String password);

	Admin verifyAdminLogin(String email, String password);

	String registerFaculty(Faculty faculty);

	String fetchPassword(String email);

}
