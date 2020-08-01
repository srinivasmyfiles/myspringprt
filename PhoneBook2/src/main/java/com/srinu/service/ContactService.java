package com.srinu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.srinu.model.ContactModel;

@Service
public interface ContactService {
	public boolean saveContact(ContactModel cm);
	public List<ContactModel> getAllContacts();
	public ContactModel getContactById(Integer contactId);
	public boolean updateContact(ContactModel cm);
	public boolean deleteContact(Integer contactId);
	

}
