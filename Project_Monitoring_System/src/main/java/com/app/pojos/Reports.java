package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Reports extends BaseEntity {

	private String description;
	private String srs;
	private String report;
	private String ppt;
	private String demo1;
	private String demo2;
	private String demo3;
	private String marks;
	public Reports() {
		super();
	}
	public Reports(String description, String srs, String report, String ppt, String demo1, String demo2, String demo3,
			String marks) {
		super();
		this.description = description;
		this.srs = srs;
		this.report = report;
		this.ppt = ppt;
		this.demo1 = demo1;
		this.demo2 = demo2;
		this.demo3 = demo3;
		this.marks = marks;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSrs() {
		return srs;
	}
	public void setSrs(String srs) {
		this.srs = srs;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getPpt() {
		return ppt;
	}
	public void setPpt(String ppt) {
		this.ppt = ppt;
	}
	public String getDemo1() {
		return demo1;
	}
	public void setDemo1(String demo1) {
		this.demo1 = demo1;
	}
	public String getDemo2() {
		return demo2;
	}
	public void setDemo2(String demo2) {
		this.demo2 = demo2;
	}
	public String getDemo3() {
		return demo3;
	}
	public void setDemo3(String demo3) {
		this.demo3 = demo3;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Reports [description=" + description + ", srs=" + srs + ", report=" + report + ", ppt=" + ppt
				+ ", demo1=" + demo1 + ", demo2=" + demo2 + ", demo3=" + demo3 + ", marks=" + marks + "]";
	}
	
	
	
}
