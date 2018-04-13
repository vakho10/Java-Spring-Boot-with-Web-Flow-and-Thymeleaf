package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Model model) {
		model.addAttribute("message", "Hello, world!");
		return "index";
	}
}