package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address extends BaseEntity {
	private String address1;
	private String address2;
	private String state;
	private String zip;
	private String country;

	
	public Address() {
		System.out.println("Address Table is Getting Ready......");
	}

	public Address(String address1, String address2, String state, String zip, String country) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", state=" + state + ", zip=" + zip
				+ ", country=" + country + "]";
	}
	
	
	
}
