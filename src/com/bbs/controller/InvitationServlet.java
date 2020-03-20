package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.Invitation;
import com.bbs.service.InvitationService;
import com.bbs.service.impl.InvitationServiceImpl;



/**
 * Servlet implementation class InvitationServlet
 */
@WebServlet("/InvitationServlet")
public class InvitationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 //创建一个业务层对象
		private InvitationService ps=new InvitationServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvitationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得客户端传递的参数值
				request.setCharacterEncoding("UTF-8");
				String op=request.getParameter("op");
				if("add".equals(op)) {
					//调用增加模块的方法
					saveInvitation(request,response);
				}else if("show".equals(op)){
					findAll(request,response);
				}
				else if("delById".equals(op)){
					delById(request,response);
				}else if("update".equals(op)){
					update(request,response);
				}else if("findEdit".equals(op)){
					findEdit(request,response);
				}else if("delAll".equals(op)) {
					delAll(request,response);
				}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String invitationId=request.getParameter("invitationId");
		String invitationMessage=request.getParameter("invitationMessage");
		String plateId=request.getParameter("plateId");
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		System.err.println(invitationId+","+invitationMessage+","+plateId+","+categoryId);
		Invitation invitation=new Invitation();
		invitation.setInvitationId(invitationId);
		invitation.setInvitationMessage(invitationMessage);
		invitation.setPlateTitle(plateId);
		invitation.setCategoryId(categoryId);
		boolean isOk = ps.update(invitation);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	}

	private void delAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String invitationIds = request.getParameter("invitationIds");
		//["test001","test002"]
		PrintWriter out = response.getWriter();
		boolean isOk = ps.delAll(invitationIds);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}

	private void findEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String invitationId = request.getParameter("invitationId");
		Invitation invitation = ps.findEdit(invitationId);
		if(invitation != null) {
			request.getSession().setAttribute("invitation", invitation);
			response.sendRedirect("server/invitation-edit.jsp");
		}
	}

	private void delById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String invitationId = request.getParameter("invitationId");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		boolean isOk = ps.delById(invitationId);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//创建保存数据的集合
		List<Invitation> lists=null;
		try {
			lists = ps.getInvitationList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("lists", lists);
		request.getRequestDispatcher("server/invitation-list.jsp").forward(request, response);
		
	}

	private void saveInvitation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置响应的文件类型
				response.setContentType("spplication/json;charset=UTF-8");
				//获得表单的提交数据
				String invitationMessage=request.getParameter("invitationMessage");
				String plateId=request.getParameter("plateId");
				int categoryId=Integer.parseInt(request.getParameter("categoryId"));
				String userId = (String) request.getSession().getAttribute("userId");
				// 得到系统的默认时间
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String invitationId = userId+format.format(date);
				Invitation invitation=new Invitation(invitationId,invitationMessage,userId,plateId,categoryId);
				boolean isOK=ps.saveInvitation(invitation);
				PrintWriter pw=response.getWriter();
				if(isOK) {
					pw.write("{\"result\":\"true\"}");
				}else {
					pw.write("{\"result\":\"false\"}");
				}
				pw.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
