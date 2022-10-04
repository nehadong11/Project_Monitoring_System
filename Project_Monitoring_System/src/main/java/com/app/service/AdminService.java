package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminDaoInterface;
import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Project;
import com.app.pojos.Students;

@Service
@Transactional
public class AdminService implements AdminServiceInterface{

	@Autowired
	private AdminDaoInterface adminDao;

	@Override
	public String updateprofileinfo(Admin admin, String name, String email, String mobile) {
		return adminDao.updateprofileinfo(admin, name, email, mobile);
	}

	@Override
	public List<Students> fetchStudents() {
		return adminDao.fetchStudents();
	}

	@Override
	public List<Faculty> fetchFaculty() {
		return adminDao.fetchFaculty();
	}

	@Override
	public List<Project> fechProject() {
		return adminDao.fechProject();
	}

	@Override
	public String toggleProject(int rid) {
		return adminDao.toggleProject(rid);
	}

	@Override
	public String toggleRProject(int rid) {
		return adminDao.toggleRProject(rid);
	}

	@Override
	public String createGroup(String groupNo, int std1, int std2, int std3, int std4) {
		
		return adminDao.createGroup(groupNo, std1, std2, std3, std4);
	}

	@Override
	public List<Students> fetchUngroupedStudents() {
		return adminDao.fetchUngroupedStudents();
	}

	@Override
	public Project fetchProjectByID(int pid) {
		return adminDao.fetchProjectByID(pid);
	}

	@Override
	public List<Project> fetchAllProjects() {
		
		return adminDao.fetchAllProjects();
	}

	@Override
	public String addGuide(int proj, int fac) {
		return adminDao.addGuide(proj, fac);
	}

	@Override
	public boolean checkAvailabe(int groupNo) {
		return adminDao.checkAvailabe(groupNo);
	}

	@Override
	public boolean groupNoAvailabe(String groupNo) {
		return adminDao.groupNoAvailabe(groupNo);
	}

	@Override
	public List<Project> fetchApprovedProject() {
		return adminDao.fetchApprovedProject();
	}

	@Override
	public List<Project> fetchRejectedProject() {
		// TODO Auto-generated method stub
		return adminDao.fetchRejectedProject();
	}

	
}
