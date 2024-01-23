package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("this is home url");
		model.addAttribute("name","Sharan J S");
		model.addAttribute("id",12552);
		
		List<String> friends = new ArrayList<String>();
		friends.add("Vandan");
		friends.add("Roshni");
		friends.add("ABC");
		model.addAttribute("f",friends);
		
		return "index";
	}
	
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("this is about controller");
		return "about";
	}
	
	//Using modelandview
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("this is help controller");
		//creating model and view object
		ModelAndView modelAndView = new ModelAndView();
		
		//setting the data
		modelAndView.addObject("name","Uttam Shukla");
		modelAndView.addObject("rollnumber", 65423);
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time", now);
		
		//marks
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(36);
		list.add(55);
		modelAndView.addObject("marks",list);
		
		//setting the view name
		modelAndView.setViewName("help");
		
		return modelAndView;
	}

}
