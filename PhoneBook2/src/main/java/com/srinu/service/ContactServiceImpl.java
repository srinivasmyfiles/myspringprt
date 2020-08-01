package com.srinu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srinu.entity.ContactEntity;
import com.srinu.model.ContactModel;
import com.srinu.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactRepository contactRepo;

	public boolean saveContact(ContactModel cm) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(cm, entity);
		ContactEntity isSavedEntity=contactRepo.save(entity);
	
		return isSavedEntity.getContactId()!=null;
	}

	public List<ContactModel> getAllContacts() {
	List<ContactEntity> entities=contactRepo.findAll();
	List<ContactModel> contacts=new  ArrayList<ContactModel>();
	//Legacy approach
	/*for(ContactEntity entity: entities) {
		ContactModel contact=new ContactModel();
	BeanUtils.copyProperties(entity,contact);
	contacts.add(contact);
	}*/
		return entities.stream().map(entity->{
			ContactModel contact=new ContactModel();
			BeanUtils.copyProperties(entity,contact);
			return contact;
		}).collect(Collectors.toList());
		
		}

	@Override
	public ContactModel getContactById(Integer contactId) {
		Optional<ContactEntity> findById =contactRepo.findById(contactId);
		if(findById.isPresent()) {
			ContactEntity contactEntity=findById.get();
			ContactModel c=new ContactModel();
			BeanUtils.copyProperties(contactEntity, c);
			return c;
			
		}
		return null;
	}

	@Override
	public boolean updateContact(ContactModel cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		
	contactRepo.deleteById(contactId);
		return true;
	}
	
}

