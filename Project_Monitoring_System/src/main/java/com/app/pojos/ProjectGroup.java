package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_group")
public class ProjectGroup extends BaseEntity {

	private String groupNo;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToMany
	private List<Students> studentList=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "report_id")
	private Reports report;
	
	public ProjectGroup() {
		super();
	}

	public Reports getReport() {
		return report;
	}

	public void setReport(Reports report) {
		this.report = report;
	}

	public List<Students> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Students> studentList) {
		this.studentList = studentList;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ProjectGroup [groupNo=" + groupNo + ", project=" + project + "]";
	}
	
}
