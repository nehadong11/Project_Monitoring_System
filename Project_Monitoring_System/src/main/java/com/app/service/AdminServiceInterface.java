package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Project;
import com.app.pojos.Students;

public interface AdminServiceInterface {

	String updateprofileinfo(Admin admin, String name, String email, String mobile);

	List<Students> fetchStudents();

	List<Faculty> fetchFaculty();

	List<Project> fechProject();

	String toggleProject(int rid);

	String toggleRProject(int rid);

	String createGroup(String groupNo, int std1, int std2, int std3, int std4);

	List<Students> fetchUngroupedStudents();

	Project fetchProjectByID(int pid);

	List<Project> fetchAllProjects();

	String addGuide(int proj, int fac);

	boolean checkAvailabe(int groupNo);

	boolean groupNoAvailabe(String groupNo);

	List<Project> fetchApprovedProject();

	List<Project> fetchRejectedProject();

	

}
