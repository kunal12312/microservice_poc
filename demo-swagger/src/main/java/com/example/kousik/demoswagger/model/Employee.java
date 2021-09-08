package com.example.kousik.demoswagger.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlAccessType;

@Entity
@Table(name = "employee")
@ApiModel(description="All details about the Employee. ")
@XmlRootElement (name = "employee")
@XmlAccessorType(XmlAccessType.NONE)

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "The database generated employee ID")
	
	private long id;

	@ApiModelProperty(notes = "The employee first name")
	  @XmlElement
	private String firstName;

	@ApiModelProperty(notes = "The employee last name")
	  @XmlElement
	private String lastName;

	@ApiModelProperty(notes = "The employee email id")
	  @XmlElement
	private String emailId;
	
	@ApiModelProperty(notes = "The employee phone no")
	  @XmlElement
	private String phone;
	
	private Set<Address> address=new HashSet<Address>();
	

	public Employee() {

	}

	public Employee(String firstName, String lastName, String emailId,String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone=phone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity=Address.class)
	@JsonManagedReference
	@OneToMany(mappedBy = "employee" ,targetEntity = Address.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//@LazyCollection(LazyCollectionOption.FALSE)
	public Set<Address> getAddress() {
		return address;
	}
	
	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}

}