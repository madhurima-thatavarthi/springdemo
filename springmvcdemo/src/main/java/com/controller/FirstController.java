package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping(value = "/main")
public class FirstController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String first() {
		return "hello"; // view page ->view resolver -> prefix WEB-INF/pages .jsp
	}

	// @RequestMapping(value="/two")
	@GetMapping(value = { "/two", "/three" })
	// @PostMapping
	public String second() {
		return "world";
	}

	@PostMapping(value = "/four")
	public String third(@RequestParam("userID") int udata, @RequestParam("username") String userName, Model model) {
		System.out.println("UI data received:" + udata);
		System.out.println("UI data received username:" + userName);
		model.addAttribute("key1", userName);
		return "success";
	}

	@PostMapping(value = "/five")
	public ModelAndView five(@RequestParam("userID") int udata, @RequestParam("username") String userName) {
		System.out.println("UI data received:" + udata);
		System.out.println("UI data received username:" + userName);
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("key1", udata);
		return modelAndView;
	}

	@GetMapping(value = "/six/{alias}")
	public String six(@PathVariable("alias") String userName, Model model) {
		System.out.println("Path Variable" + userName);

		User user = new User(12, "madhurima", "Thatavarthi");

		model.addAttribute("user", user);
		return "path";
	}

	@GetMapping(value = "/login4")
	public String loginForm(Model model) {
		model.addAttribute("uiobject", new User());
		return "login";
	}

	@GetMapping(value = "/loginprocess")
	public String loginData(@Valid @ModelAttribute("uiobject") User user,BindingResult bindingResult, Model model) {
		
	  /* System.out.println(user.getUserId()); 
		 System.out.println(user.getPassword());
		 String viewpage = ""; //service 
		 if(user.getUserId() > 0 && user.getPassword().length() > 0 &&
		  user.getPassword().contentEquals("hello")) 
		  {
		    user.setUserName("Good afternoon"); //DB
		    model.addAttribute("coffee", user);
		     viewpage = "afterlogin"; 
		  }  
		  else { viewpage = "failure"; }
		   return viewpage;                       */
		
		if(bindingResult.hasErrors())
		{
			return "/login"; //login.jsp
		}
		else
		{
         model.addAttribute("coffee", userService.getUserName(user));	
         return "afterlogin";
		}
	}

}
