package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	private String title;

	private String details;

	private String link;
	
	@ManyToOne
	@JoinColumn(name = "guide_id")
	private Faculty guide;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Students createdBy;

	private String status;

	public Project() {
		super();
	}

	public Project(String title, String details, Students createdBy, String status) {
		super();
		this.title = title;
		this.details = details;
		this.createdBy = createdBy;
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Students getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Students createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Faculty getGuide() {
		return guide;
	}

	public void setGuide(Faculty guide) {
		this.guide = guide;
	}

	@Override
	public String toString() {
		return "Project [title=" + title + ", details=" + details + ", guide=" + guide + "]";
	}

}
