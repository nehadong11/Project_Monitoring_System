package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Messages extends BaseEntity {

	@ManyToOne
	private Students from;//sender
	
	@ManyToOne
	private ProjectGroup group;//reciver
	
	@Column(length = 1000)
	private String msg;
	
	private String date;

	public Messages() {
		super();
	}

	public Messages(Students from, ProjectGroup group, String msg, String date) {
		super();
		this.from = from;
		this.group = group;
		this.msg = msg;
		this.date = date;
	}

	public Students getFrom() {
		return from;
	}

	public void setFrom(Students from) {
		this.from = from;
	}

	public ProjectGroup getGroup() {
		return group;
	}

	public void setGroup(ProjectGroup group) {
		this.group = group;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Messages [from=" + from + ", group=" + group + ", msg=" + msg + ", date=" + date + "]";
	}

}
