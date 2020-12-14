package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/demo2")
public class SecondController {
	

    
	@GetMapping(value="/one1")
	public String one()
	{
		System.out.println("You are in first function");
		return "redirect:/two2";
	}
	@GetMapping(value="/two2")
	public String two()
	{
		System.out.println("You are in second function");
		return "secondpage";
	}
}
