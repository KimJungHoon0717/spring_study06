package com.JungHoon.home.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JungHoon.home.dao.BDao;

public class BWriteCommand implements BCommand {

	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		//model 객체 안에 있는 request를 map 매핑
		HttpServletRequest Request = (HttpServletRequest) map.get("request");
		
		String bname =Request.getParameter("bname");
		String btitle =Request.getParameter("btitle");
		String bcontent =Request.getParameter("bcontent");
		
		BDao dao = new BDao();
		dao.write(bname,btitle,bcontent);
	}

}
