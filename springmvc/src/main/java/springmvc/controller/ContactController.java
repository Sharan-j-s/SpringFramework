package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute //this will be called automatically for both pages
	public void commonDataForModel(Model model) {
		model.addAttribute("Header","Registration Form");
		model.addAttribute("Desc","Form to get the customer details");
	}
	
	@RequestMapping("/contact")
	public String showForm(Model model){

		return "contact";
	}
	
	//using modelattribute, will decrease lines of code
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		
		if(user.getUserName().isBlank())
			return "redirect:/contact";
		
		int createdUser = this.userService.createUser(user);
		model.addAttribute("msg", "User created with id "+createdUser);
		return "success";
	}
	
	/*
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam("email") String userEmail, @RequestParam("userName") String userName,
			@RequestParam("password") String userPassword, Model model) {
		
		User user = new User();
		user.setEmail(userEmail);
		user.setUserName(userName);
		user.setPassword(userPassword);
		
		System.out.println(user);
		
		model.addAttribute("user",user);
		
//		model.addAttribute("name",userName);
//		model.addAttribute("email",userEmail);
//		model.addAttribute("password",userPassword);
		
		return "success";
	}
	*/
}
