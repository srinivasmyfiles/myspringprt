package com.srinu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srinu.entity.ContactEntity;
import com.srinu.model.ContactModel;
import com.srinu.service.ContactService;

@Controller
public class ViewContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping("/editContact")
	public String editContact(@RequestParam("contactId") Integer contactId, Model model) {
		ContactModel contactById = contactService.getContactById(contactId);
		model.addAttribute("contact", contactById);

		return "contactInfo";

	}

	/*
	 * @RequestMapping(value="/update",method=RequestMethod.POST) public String
	 * updateContact(@ModelAttribute ContactEntity ce,Model model) { return null;
	 * 
	 * }
	 */
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("contactId") Integer contactId) {
		boolean isDeleted = contactService.deleteContact(contactId);
		if (isDeleted) {
			return "redirect:/viewContacts";
		}

		return null;
	}
}
