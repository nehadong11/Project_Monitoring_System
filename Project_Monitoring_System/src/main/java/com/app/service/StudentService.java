package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDaoInterface;
import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Students;

@Service
@Transactional
public class StudentService implements StudentServiceInterface {

	@Autowired
	private StudentDaoInterface studentDao;

	@Override
	public String updateStudentInfo(Students std, String prn, String courseBatchYear, String courseDuration,
			String courseName, String name, String email, String locality, String address, String state, String zip,
			String country, String gender, String mobile) {
		return studentDao.updateStudentInfo(std, prn, courseBatchYear, courseDuration, courseName, name, email,
				locality, address, state, zip, country, gender, mobile);
	}

	@Override
	public String createProject(Project project) {
		return studentDao.createProject(project);
	}

	@Override
	public List<Project> fetchMyProject(Students std) {
		return studentDao.fetchMyProject(std);
	}

	@Override
	public ProjectGroup fetchStudentGroup(Students std) {
		return studentDao.fetchStudentGroup(std);
	}

	@Override
	public String addProjecttogroup(ProjectGroup group, Project proj) {
		return studentDao.addProjecttogroup(group, proj);
	}

	@Override
	public String addChat(Messages msg1) {
		return studentDao.addChat(msg1);
	}

	@Override
	public List<Messages> fetchChat(Students std) {
		return studentDao.fetchChat(std);
	}

	@Override
	public List<Students> fetchMyGroupMembers(Students std) {
		return studentDao.fetchMyGroupMembers(std);
	}

	@Override
	public String addLink(String link, Project project) {
		return studentDao.addLink(link, project);
	}
	

}
