package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Faculty;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Reports;
import com.app.pojos.Students;

@Repository
public class AdminDao implements AdminDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String updateprofileinfo(Admin admin, String name, String email, String mobile) {
		Admin admin1 = mgr.find(Admin.class, admin.getId());
		admin1.setName(name);
		admin1.setEmail(email);
		admin1.setMobile(mobile);
		return "Admin Details Updated";
	}

	@Override
	public List<Students> fetchStudents() {
		try {
			String jpql = "select s from Students s";
			List<Students> studentList = mgr.createQuery(jpql, Students.class).getResultList();
			if (studentList != null)
				return studentList;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Faculty> fetchFaculty() {
		try {
			String jpql = "select f from Faculty f";
			List<Faculty> facultyList = mgr.createQuery(jpql, Faculty.class).getResultList();
			if (facultyList != null)
				return facultyList;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Project> fechProject() {
		try {
			String jpql = "select p from Project p where p.status=:status";
			List<Project> projectList = mgr.createQuery(jpql, Project.class)
					.setParameter("status", "Waiting for Approval").getResultList();
			if (projectList != null)
				return projectList;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String toggleProject(int rid) {
		Project proj = mgr.find(Project.class, rid);
		
		proj.setStatus("Approved");
		
		return "Status Changed";
	}

	@Override
	public String toggleRProject(int rid) {
		Project proj = mgr.find(Project.class, rid);
		proj.setStatus("Rejected");
		return "Status Changed";
	}

	@Override
	public String createGroup(String groupNo, int std1, int std2, int std3, int std4) {
		System.out.println("Step 3");
		Reports report = new Reports("Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending",
				"Pending");

		System.out.println("step 4");
		ProjectGroup pg = new ProjectGroup();
		pg.setGroupNo(groupNo);
		List<Students> studentList = new ArrayList<>();
		if (std1 != 0) {
			Students s1 = mgr.find(Students.class, std1);
			s1.setProjectGroup(pg);
			studentList.add(s1);
		}
		if (std2 != 0) {
			Students s2 = mgr.find(Students.class, std2);
			s2.setProjectGroup(pg);
			studentList.add(s2);
		}
		if (std3 != 0) {
			Students s3 = mgr.find(Students.class, std3);
			s3.setProjectGroup(pg);
			studentList.add(s3);
		}
		if (std4 != 0) {
			Students s4 = mgr.find(Students.class, std4);
			s4.setProjectGroup(pg);
			studentList.add(s4);
		}
		pg.setStudentList(studentList);
		pg.setReport(report);
		mgr.persist(pg);
		return "Group Created Successfully";

	}
	@Override
	public List<Students> fetchUngroupedStudents() {
		try {
			String jpql = "select s from Students s where s.projectGroup=:group";
			ProjectGroup pg = null;
			List<Students> studentList = mgr.createQuery(jpql, Students.class).setParameter("group", pg)
					.getResultList();
			if (studentList != null)
				return studentList;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Project fetchProjectByID(int pid) {

		return mgr.find(Project.class, pid);
	}

	@Override
	public List<Project> fetchAllProjects() {
		String jpql = "select p from Project p where p.status=:status";
		List<Project> list = mgr.createQuery(jpql, Project.class).setParameter("status", "Added to project")
				.getResultList();
		if (list != null)
			return list;
		return null;
	}

	@Override
	public String addGuide(int proj, int fac) {
		Project project = mgr.find(Project.class, proj);
		Faculty guide = mgr.find(Faculty.class, fac);
		project.setGuide(guide);
		return "Guide Assigned";
	}

	@Override
	public boolean checkAvailabe(int groupNo) {
		String jpql = "Select p from ProjectGroup p where p.groupNo=:no";
		ProjectGroup pg = mgr.createQuery(jpql, ProjectGroup.class).setParameter("no", groupNo).getSingleResult();
		if (pg != null)
			return true;
		return false;
	}

	@Override
	public boolean groupNoAvailabe(String groupNo) {
		System.out.println("group No Avaialabe");
		String jpql = "Select p from ProjectGroup p";
		List<ProjectGroup> pg = mgr.createQuery(jpql, ProjectGroup.class).getResultList();
		int count = 0;
		for (ProjectGroup p : pg) {
			if (p.getGroupNo().equals(groupNo)) {
				count = count + 1;
			} else {
				continue;
			}
		}
		if (count == 1)
			return false;
		return true;
	}

	@Override
	public List<Project> fetchApprovedProject() {
		String jpql = "select p from Project p where p.status=:status";
		List<Project> list = mgr.createQuery(jpql, Project.class).setParameter("status", "Added to project")
				.getResultList();
		String jpql1 = "select p from Project p where p.status=:status";
		List<Project> list1 = mgr.createQuery(jpql1, Project.class).setParameter("status", "Approved")
				.getResultList();
		list.addAll(list1);
		if (list != null)
			return list;
		return null;
	}

	@Override
	public List<Project> fetchRejectedProject() {
		String jpql = "select p from Project p where p.status=:status";
		List<Project> list = mgr.createQuery(jpql, Project.class).setParameter("status", "Rejected")
				.getResultList();
		
		if (list != null)
			return list;
		return null;
	}

}
