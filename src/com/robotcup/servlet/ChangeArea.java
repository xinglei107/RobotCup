package com.robotcup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robotcup.domain.TeamUnversity;
import com.robotcup.service.inter.ExecuteQueryInter;

public class ChangeArea extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");//禁用缓存
		int aid=Integer.parseInt(request.getParameter("aid"));
		WebApplicationContext wac=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//从spring容器中，取出了 UniversityServiceInter 类型的bean
		ExecuteQueryInter universityService=(ExecuteQueryInter)wac.getBean("executeQueryImp");
		
		List<TeamUnversity> uniList=universityService.getUniversityByAid(aid);
		
		String res = "<allUniversities>";
		
		for (int i = 0; i < uniList.size(); i++) {
			TeamUnversity u = uniList.get(i);
			res += "<unis><id>" + u.getSid() + "</id><name><![CDATA["
					+ u.getSname() + "]]></name></unis>";
		}
		res += "</allUniversities>";
		out.write(res);
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
