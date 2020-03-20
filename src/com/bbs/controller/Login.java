package com.bbs.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.bbs.entity.Plate;
import com.bbs.service.PlateService;
import com.bbs.service.UserService;
import com.bbs.service.impl.PlateServiceImpl;
import com.bbs.service.impl.UserServiceImpl;
@WebServlet("/Login")
public class Login extends HttpServlet {
	// 创建业务层接口对象
	private UserService us=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//获得页面参数
		String userId=req.getParameter("userId");
		String userPsw=req.getParameter("userpsw");
		 userPsw=DigestUtils.md5Hex(userPsw);  
		//调用业务层验证登录的方法֤
		boolean isOk=us.Verification(userId, userPsw);
		//判断结果，根据结果进行页面跳转
		if(isOk) {
			// 获得所有的模块信息
			PlateService ps=new PlateServiceImpl();
			List<Plate> plist = null;
			try {
				plist = ps.getPlateList();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getSession().setAttribute("plist", plist);
			
			req.getSession().setAttribute("userId", userId);
			req.getRequestDispatcher("UserServlet?op=index").forward(req, resp);
		}else {
			resp.sendRedirect("login.html");
		}
	}

}
