package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Faculty;
import com.app.pojos.Messages;
import com.app.pojos.Project;
import com.app.pojos.ProjectGroup;
import com.app.pojos.Reports;

@Repository
public class FacultyDao implements FacultyDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Project> fetchMyProjects(Faculty fac) {
		String jpql = "select p from Project p where p.guide=:fac";
		List<Project> list = mgr.createQuery(jpql, Project.class).setParameter("fac", fac).getResultList();
		if (list != null)
			return list;
		return null;
	}

	@Override
	public List<ProjectGroup> fetchMyGroups(Faculty fac) {
		String jpql = "select p from ProjectGroup p";
		List<ProjectGroup> list = mgr.createQuery(jpql, ProjectGroup.class).getResultList();
		List<ProjectGroup> list1 = new ArrayList<>();
		for (ProjectGroup p : list) {
			if (p.getProject().getGuide().equals(fac)) {
				list1.add(p);
			} else {
				continue;
			}
		}
		if (list1 != null)
			return list1;
		return null;
	}

	@Override
	public List<Messages> fetchChat(int pid) {
		Project p=mgr.find(Project.class, pid);
		String jpql1 = "select p from ProjectGroup p where p.project=:proj";
		ProjectGroup pg = mgr.createQuery(jpql1, ProjectGroup.class).setParameter("proj", p).getSingleResult();

		String jpql = "select m from Messages m where m.group=:pg";
		List<Messages> list = mgr.createQuery(jpql, Messages.class).setParameter("pg", pg).getResultList();
		if (list != null)
			return list;
		return null;
	}

	@Override
	public Reports fetchReport(int pid) {
		Project p=mgr.find(Project.class, pid);
		String jpql1 = "select p from ProjectGroup p where p.project=:proj";
		ProjectGroup pg = mgr.createQuery(jpql1, ProjectGroup.class).setParameter("proj", p).getSingleResult();
		
		return pg.getReport();
	}

	@Override
	public String updateReport(int rid, String description, String demo1, String demo2, String demo3, String marks,
			String srs, String report, String ppt) {
		Reports r=mgr.find(Reports.class, rid);
		r.setDemo1(demo1);
		r.setDemo2(demo2);
		r.setDemo3(demo3);
		r.setDescription(description);
		r.setMarks(marks);
		r.setPpt(ppt);
		r.setReport(report);
		r.setSrs(srs);
		return "Report Updated";
	}

}
