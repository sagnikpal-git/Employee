/**
 * 
 */
package com.example.Employee.model;

import javax.persistence.*;

/**
 * @author 
 *
 */
@Entity
@Table(name = "employeetable")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	private long employeecode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "emailid")
	private String emailid;
	
	@Column(name = "experience")
	private int experience;
	
	@Column(name = "phonenumber")
	private long phonenumber;
	
	@Column(name = "status")
	private String status;
		
	public Employee() {
		super();
	}

	public Employee(long employeecode, String name, String gender, String designation, String emailid, int experience,
			long phonenumber, String status) {
		super();
		this.employeecode = employeecode;
		this.name = name;
		this.gender = gender;
		this.designation = designation;
		this.emailid = emailid;
		this.experience = experience;
		this.phonenumber = phonenumber;
		this.status = status;
	}

	public long getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(long employeecode) {
		this.employeecode = employeecode;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [employeecode=" + employeecode + ", name=" + name + ", gender=" + gender + ", designation="
				+ designation + ", emailid=" + emailid + ", experience=" + experience + ", phonenumber=" + phonenumber
				+ ", status=" + status + "]";
	}
}
