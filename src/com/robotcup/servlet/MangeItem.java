package com.robotcup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamItems;
import com.robotcup.service.imp.TeamAdminServiceImp;

/**
 * 2016-03-26允许修改人数上下限
 * 
 * @author xl
 * 
 */
public class MangeItem extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MangeItem() {
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int itid = Integer.parseInt(request.getParameter("itid"));
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
		TeamItems item = teamAdminServiceImp.getTeamItemByItid(itid);
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"tyid\":");
		json.append("\"" + item.getItemsType().getTyid() + "\",");
		json.append("\"itid\":");
		json.append("\"" + item.getItid() + "\",");
		json.append("\"itname\":");
		json.append("\"" + item.getItname() + "\",");
		json.append("\"stulim\":");
		json.append("\"" + item.getItremark() + "\",");
		json.append("\"stucap\":");
		json.append("\"" + item.getItlimit() + "\",");
		json.append("\"tealim\":");
		json.append("\"" + item.getIttealim() + "\",");
		json.append("\"teacap\":");
		json.append("\"" + item.getItteacap() + "\",");
		json.append("\"type\":");
		json.append("\"" + item.getItemsType().getTyname() + "\"");
		json.append("}");
		out.write(json.toString());
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
		String itid_ = request.getParameter("itid");
		String stulim_ = request.getParameter("stulim");
		String stucap_ = request.getParameter("stucap");
		String tealim_ = request.getParameter("tealim");
		String teacap_ = request.getParameter("teacap");
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
		TeamItems item = new TeamItems();
		item.setItid(Integer.parseInt(itid_));
		item.setItremark(stulim_);
		item.setItlimit(Integer.parseInt(stucap_));
		item.setIttealim(Integer.parseInt(tealim_));
		item.setItteacap(Integer.parseInt(teacap_));
		teamAdminServiceImp.updateItemByItid(item);
		response.sendRedirect("manageCom.do?method=item");
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
