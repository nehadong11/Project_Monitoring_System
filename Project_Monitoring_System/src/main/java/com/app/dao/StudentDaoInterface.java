package com.app.dao;

import java.util.List;

import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Students;

public interface StudentDaoInterface {

	

	String updateStudentInfo(Students std, String prn, String courseBatchYear, String courseDuration, String courseName,
			String name, String email, String locality, String address, String state, String zip, String country,
			String gender, String mobile);

	String createProject(Project project);

	List<Project> fetchMyProject(Students std);

	ProjectGroup fetchStudentGroup(Students std);

	String addProjecttogroup(ProjectGroup group, Project proj);

	String addChat(Messages msg1);

	List<Messages> fetchChat(Students std);

	List<Students> fetchMyGroupMembers(Students std);

	String addLink(String link, Project project);
	
	

	

}
