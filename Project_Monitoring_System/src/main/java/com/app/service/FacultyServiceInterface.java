package com.app.service;

import java.util.List;

import com.app.pojos.Faculty;
import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Reports;

public interface FacultyServiceInterface {

	List<Project> fetchMyProjects(Faculty fac);

	List<ProjectGroup> fetchMyGroups(Faculty fac);

	List<Messages> fetchChat(int pid);

	Reports fetchReport(int pid);

	String updateReport(int rid, String description, String demo1, String demo2, String demo3, String marks, String srs,
			String report, String ppt);

}
