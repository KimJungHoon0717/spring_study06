package com.JungHoon.home.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.JungHoon.home.dao.BDao;
import com.JungHoon.home.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
	}

}
