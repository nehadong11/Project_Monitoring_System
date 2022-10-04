package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "std_table")
public class Students extends BaseEntity {

	@Column(name = "std_prn", length = 30)
	private String prn;
	
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "gender", length = 10)
	private String gender;
	@Column(name = "std_email", length = 30)
	private String sEmail;
	@Column(name = "std_mobile", length = 15)
	private String sMobile;
	@Column(name = "course_name", length = 40)
	private String courseName;
	@Column(name = "course_batch_year", length = 15)
	private String courseBatchYear;
	@Column(name = "course_duration", length = 10)
	private String courseDuration;
	@Column(name = "password", length = 30)
	private String password;
	@Column(name = "status", length = 10)
	private String status;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "assigned_group_id")
	private ProjectGroup projectGroup;

	public Students() {
		System.out.println("Student Table is Getting Ready.......");
	}

	public Students(String prn, String name, String gender, String sEmail, String sMobile, String courseName,
			String courseBatchYear, String courseDuration, String password, String status) {
		super();
		this.prn = prn;
		this.name = name;
		this.gender = gender;
		this.sEmail = sEmail;
		this.sMobile = sMobile;
		this.courseName = courseName;
		this.courseBatchYear = courseBatchYear;
		this.courseDuration = courseDuration;
		this.password = password;
		this.status = status;
	}

	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsMobile() {
		return sMobile;
	}

	public void setsMobile(String sMobile) {
		this.sMobile = sMobile;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseBatchYear() {
		return courseBatchYear;
	}

	public void setCourseBatchYear(String courseBatchYear) {
		this.courseBatchYear = courseBatchYear;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [prn=" + prn + ", name=" + name + ", gender=" + gender + ", sEmail=" + sEmail + ", sMobile="
				+ sMobile + ", courseName=" + courseName + ", courseBatchYear=" + courseBatchYear + ", courseDuration="
				+ courseDuration + ", password=" + password + ", status=" + status + ", address=" + address
				+ ", projectgroup= ";
	}

}
