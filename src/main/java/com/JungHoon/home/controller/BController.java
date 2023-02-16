package com.JungHoon.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JungHoon.home.command.BCommand;
import com.JungHoon.home.command.BContentCommand;
import com.JungHoon.home.command.BListCommand;
import com.JungHoon.home.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		command = new BListCommand();
		command.excute(model);
				
		
		return "list";
	}
	@RequestMapping(value = "/write",method = RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	@RequestMapping(value = "/writeForm")
	public String writeForm() {
	
		return "write_From";
	
	}
	@RequestMapping(value = "/contentView")
	public String contentview(HttpServletRequest request,Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model); 
		
		return "content_View";
	}
	
}
