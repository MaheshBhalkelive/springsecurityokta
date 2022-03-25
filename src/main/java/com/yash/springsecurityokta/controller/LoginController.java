package com.yash.springsecurityokta.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yash.springsecurityokta.exception.UserNotFoundException;
import com.yash.springsecurityokta.repository.UserRepository;

@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public void welcome(HttpServletResponse httpServletResponse, Principal principal ) throws IOException {
		/*
		 * String userName = principal.getName(); System.out.println(userName); String
		 * userNameDb = userRepository.findByUserName(userName);
		 * System.out.println(userNameDb);
		 */
		httpServletResponse.sendRedirect("https://www.deere.com/en/finance/financing/application/");
		
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@GetMapping("/Infogram")
	public void welcometoInfogram(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.sendRedirect("https://infogram.com/login");
		}
	
}
