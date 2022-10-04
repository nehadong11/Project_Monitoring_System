package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Students;

@Repository
public class StudentDao implements StudentDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String updateStudentInfo(Students std, String prn, String courseBatchYear, String courseDuration,
			String courseName, String name, String email, String locality, String address, String state, String zip,
			String country, String gender, String mobile) {
		Students std1 = mgr.find(Students.class, std.getId());
		std1.setCourseBatchYear(courseBatchYear);
		std1.setCourseDuration(courseDuration);
		std1.setCourseName(courseName);
		std1.setGender(gender);
		std1.setName(name);
		std1.setPrn(prn);
		std1.setsEmail(email);
		std1.setsMobile(mobile);
		Address add = new Address(locality, address, state, zip, country);
		std1.setAddress(add);
		return "Student Details Updated";
	}

	@Override
	public String createProject(Project project) {
		mgr.persist(project);
		return "Project Saved SuccessFully Waiting for Approval";
	}

	@Override
	public List<Project> fetchMyProject(Students std) {
		try {
			String jpql = "select p from Project p where p.createdBy=:std";
			List<Project> pList = mgr.createQuery(jpql, Project.class).setParameter("std", std).getResultList();
			if (pList != null)
				return pList;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ProjectGroup fetchStudentGroup(Students std) {

		return mgr.find(ProjectGroup.class, std.getProjectGroup().getId());
	}

	@Override
	public String addProjecttogroup(ProjectGroup group, Project proj) {
		ProjectGroup pg = mgr.find(ProjectGroup.class, group.getId());
		
		pg.getReport().setDescription("Accepted");
		pg.setProject(proj);
		
		Project p = mgr.find(Project.class, proj.getId());
		p.setStatus("Added to project");
		return "Project Added to the group";
	}

	@Override
	public String addChat(Messages msg1) {
		mgr.persist(msg1);
		return "Message Sent Successfully";
	}

	@Override
	public List<Messages> fetchChat(Students std) {
		ProjectGroup pg = std.getProjectGroup();
		String jpql = "select m from Messages m where m.group=:pg";
		List<Messages> list = mgr.createQuery(jpql, Messages.class).setParameter("pg", pg).getResultList();
		if (list != null)
			return list;
		return null;
	}

	@Override
	public List<Students> fetchMyGroupMembers(Students std) {
		try {
			ProjectGroup pg = std.getProjectGroup();
			String jpql = "Select s from Students s where s.projectGroup=:pg";
			List<Students> list = mgr.createQuery(jpql, Students.class).setParameter("pg", pg).getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String addLink(String link, Project project) {
		try {
			Project p = mgr.find(Project.class, project.getId());

			p.setLink(link);
			return "Link is Uploaded";
		} catch (Exception e) {
			return "Contact Group Leader to add project and get Approval to add git link";
		}

	}
	
	
	
	


}
