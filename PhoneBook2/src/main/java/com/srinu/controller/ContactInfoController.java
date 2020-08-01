package com.srinu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srinu.model.ContactModel;
import com.srinu.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = { "/", "/login" })
	public String loginForm() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String loginCheck(HttpServletRequest req, RedirectAttributes ra, Model model) {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");

		if (uname.equals("admin") && pwd.equals("admin")) {
			ra.addFlashAttribute("uname", uname);
			// redirect to buildDashBoard
			return "redirect:/form";
		}

		model.addAttribute("msg", "Invalid Credentials");
		return "login";
	}
	
	@GetMapping(value="/form")
	public String loadForm(Model model) {
		ContactModel c=new ContactModel();
		model.addAttribute("contact", c);
		
		return "contactInfo";
		
	}
	@PostMapping(value="/saveContact")
	public  String handleSubmitBtn(@ModelAttribute("contact") ContactModel cm,Model model) {
		boolean isSaved=contactService.saveContact(cm);
		if(isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		}else {
			model.addAttribute("errMsg", "Failed to save contact");
			
		}
		return "contactInfo";
		
	} 
	@GetMapping(value="/viewContacts")
	public String handleViewContactLink(Model model) {
		List<ContactModel> contactList=contactService.getAllContacts();
		model.addAttribute("contacts", contactList);
		return "viewContacts";	}

}
