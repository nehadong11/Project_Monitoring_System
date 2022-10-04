package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FacultyDaoInterface;
import com.app.pojos.Faculty;
import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Reports;

@Service
@Transactional
public class FacultyService implements FacultyServiceInterface {

	@Autowired
	private FacultyDaoInterface facultyDao;
	@Override
	public List<Project> fetchMyProjects(Faculty fac) {
		// TODO Auto-generated method stub
		return facultyDao.fetchMyProjects(fac);
	}
	@Override
	public List<ProjectGroup> fetchMyGroups(Faculty fac) {
		// TODO Auto-generated method stub
		return facultyDao.fetchMyGroups(fac);
	}
	@Override
	public List<Messages> fetchChat(int pid) {
		// TODO Auto-generated method stub
		return facultyDao.fetchChat(pid);
	}
	@Override
	public Reports fetchReport(int pid) {
		// TODO Auto-generated method stub
		return facultyDao.fetchReport(pid);
	}
	@Override
	public String updateReport(int rid, String description, String demo1, String demo2, String demo3, String marks,
			String srs, String report, String ppt) {
		// TODO Auto-generated method stub
		return facultyDao.updateReport(rid, description, demo1, demo2, demo3, marks, srs, report, ppt);
	}
	

}
