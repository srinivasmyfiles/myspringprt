package com.srinu.model;

import java.util.Date;

import lombok.Data;
@Data
public class ContactModel {
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private  Long contactNumber;
	private Date createdDate;
	private Date updatedDate;
	public ContactModel() {
		super();
	
	}
	public ContactModel(String contactName, String contactEmail, Long contactNumber, Date createdDate,
			Date updatedDate) {
		super();
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


}
