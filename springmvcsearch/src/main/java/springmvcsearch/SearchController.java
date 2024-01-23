package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/user/{userId}/{userName}")
	public String getUserDetail(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {
		System.out.println(userId);
		System.out.println(userName);
		return "home";
	}
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("going to home view...");
		//process area - example for exception handling - check last function exceptionHandlerNull() in this file
	//	String str = null;
	//	System.out.println(str.length()); //we get exception here
		
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		
		RedirectView redirectView = new RedirectView();
		
		if(query.isBlank()) {
			redirectView.setUrl("home");
			return redirectView;
		}
		
		String url = "https://www.google.com/search?q="+query;		
		redirectView.setUrl(url);
		
		return redirectView;
	}
	
	//Handling  exception in our spring mvc - check MyExceptionHandler class
	/*
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NullPointerException.class)
	public String exceptionHandlerNull(Model model) {
		model.addAttribute("msg","Null Pointer exception has occured");
		return "null_page";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NumberFormatException.class)
	public String exceptionHandlerNumberFormat(Model model) {
		model.addAttribute("msg","Number Format exception has occured");
		return "null_page";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandlerGeneric(Model model) {
		model.addAttribute("msg","Exception has occured");
		return "null_page";
	}
	*/

}
