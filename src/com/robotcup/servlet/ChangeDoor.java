package com.robotcup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.opc.EncryptionOption;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robotcup.domain.TeamAdmin;
import com.robotcup.parameter.Parameters;
import com.robotcup.service.imp.ExecuteQueryImp;
import com.robotcup.service.imp.TeamAdminServiceImp;
import com.robotcup.service.imp.TeamManageServiceImp;

public class ChangeDoor extends HttpServlet {

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
		String oper = request.getParameter("op");
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		// 从spring容器中，取出了 UniversityServiceInter 类型的bean
		TeamAdminServiceImp teamAdminServiceImp = (TeamAdminServiceImp) wac
				.getBean("teamAdminServiceImp");
		TeamAdmin ta = (TeamAdmin) request.getSession().getAttribute(
				"teamadmin");
		if (ta == null) {
			return;
		}
		if (oper != null)
			if (oper.equals("1")) {
				teamAdminServiceImp.changeEntrance('1');
			} else {
				teamAdminServiceImp.changeEntrance('0');
			}
		PrintWriter out = response.getWriter();
		boolean ent = teamAdminServiceImp.getEntrance();
		out.print(ent ? "1" : "0");
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

		doGet(request, response);
	}

}
