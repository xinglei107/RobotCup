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

import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamUnversity;
import com.robotcup.service.inter.ExecuteQueryInter;

public class ChgUniversity extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChgUniversity() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String yname = request.getParameter("yname");
		String nname = request.getParameter("nname");
		System.out.println(yname);
		System.out.println(nname);
		
		TeamAdmin ta = (TeamAdmin) request.getSession().getAttribute(
				"teamadmin");
		if (ta == null) {
			return;
		}
		WebApplicationContext wac=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//从spring容器中，取出了 UniversityServiceInter 类型的bean
		ExecuteQueryInter universityService=(ExecuteQueryInter)wac.getBean("executeQueryImp");
		universityService.setUniversity(yname, nname);

		request.setAttribute("chgres", "1");
		List<TeamUnversity> slist = universityService.getUniversity();
		request.getSession().setAttribute("slist", slist);
		request.getRequestDispatcher("WEB-INF/admin/manage-school.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
