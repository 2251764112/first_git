package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.bbs.service.impl.PlateServiceImpl;

/**
 * Servlet implementation class PlateServlet
 */
@WebServlet("/PlateServlet")
public class PlateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //创建一个业务层对象
	private PlateService ps=new PlateServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlateServlet() {
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
			savePlate(request,response);
		}else if("show".equals(op)){
			findAll(request,response);
		}else if("delById".equals(op)){
			delById(request,response);
		}else if("update".equals(op)){
			updatePlate(request,response);
		}else if("findEdit".equals(op)){
			findEdit(request,response);
		}else if("delAll".equals(op)) {
			delAll(request,response);
		}
	}
	//批量删除
	private void delAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String plateIds = request.getParameter("plateIds");
		//["test001","test002"]
		PrintWriter out = response.getWriter();
		boolean isOk = ps.delAll(plateIds);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}
	//增加
	private void savePlate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置响应的文件类型
		response.setContentType("spplication/json;charset=UTF-8");
		//获得表单的提交数据
		String plateTitle=request.getParameter("plateTitle");
		String plateMessage=request.getParameter("plateMessage");
		System.out.println(plateTitle+","+plateMessage);
		Plate plate=new Plate(plateTitle,plateMessage);
		boolean isOK=ps.savePlate(plate);
		PrintWriter pw=response.getWriter();
		if(isOK) {
			pw.write("{\"result\":\"true\"}");
		}else {
			pw.write("{\"result\":\"false\"}");
		}
		pw.flush();
	}
	//查询所有
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建保存数据的集合
				List<Plate> lists=null;
				try {
					lists = ps.getPlateList();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getSession().setAttribute("lists", lists);
				request.getRequestDispatcher("server/plate-list.jsp").forward(request, response);
		
	}
	//查询修改字段
	private void findEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int plateId = Integer.parseInt(request.getParameter("plateId"));
		Plate plate = ps.findEdit(plateId);
		if(plate != null) {
			request.getSession().setAttribute("plate", plate);
			response.sendRedirect("server/plate-edit.jsp");
		}
	}
	//删除单个数据
	private void delById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String plateId = request.getParameter("plateId");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		boolean isOk = ps.delById(plateId);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}
	//修改数据
	private void updatePlate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		int plateId=Integer.parseInt(request.getParameter("plateId"));
		String plateTitle = request.getParameter("plateTitle");
		String plateMessage = request.getParameter("plateMessage");
		//这里还要获取到他的主建不然的话  修改不了 
		//plate这个实体里面还缺一个plateid这个值
		Plate plate = new Plate();
		plate.setPlateId(plateId);
		plate.setPlateTitle(plateTitle);
		plate.setPlateMessage(plateMessage);
		boolean isOk = ps.update(plate);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	}

	

	
		
	

	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
