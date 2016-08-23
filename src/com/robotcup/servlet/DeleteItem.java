package com.robotcup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robotcup.domain.TeamApplication;
import com.robotcup.domain.TeamUser;
import com.robotcup.service.imp.ExecuteQueryImp;
import com.robotcup.service.imp.TeamManageServiceImp;

public class DeleteItem extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");// 禁用缓存
		PrintWriter out = response.getWriter();
		int appid = Integer.parseInt(request.getParameter("appid"));
		TeamUser user = (TeamUser) request.getSession()
				.getAttribute("teamuser");
		if (user == null) {
			return;
		}
		int tid = user.getTid();
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		// 从spring容器中，取出了 UniversityServiceInter 类型的bean
		TeamManageServiceImp teamManageServiceImp = (TeamManageServiceImp) wac
				.getBean("teamManageServiceImp");
		ExecuteQueryImp executeQueryImp = (ExecuteQueryImp) wac
				.getBean("executeQueryImp");
		teamManageServiceImp.deleteTeamApplication(appid);
		String year = (new Date().getYear() + 1900) + "";
		List<TeamApplication> applist = teamManageServiceImp.getItemsByTid(tid,
				year);

		int memberCount = 0, teaCount = 0;
		String members = "", teachers = "";
		if (applist.size() > 0) {
			members = executeQueryImp.getTeamMemberByTname(applist.get(0)
					.getTeamUser().getTname());
			teachers = executeQueryImp.getTeamTeacherByTname(applist.get(0)
					.getTeamUser().getTname());
		}

		String[] mems = members.split("、");
		String[] teas = teachers.split("、");
		memberCount = mems.length;// 队员人数
		teaCount = teas.length;
		if (members.trim().length() < 1)
			memberCount = 0;
		if (teachers.trim().length() < 1)
			teaCount = 0;
		String res = "<allUniversities><result>1</result><times>0</times>";

		for (int i = 0; i < applist.size(); i++) {
			TeamApplication u = applist.get(i);
			res += "<unis><id>" + u.getAppid() + "</id><name><![CDATA["
					+ u.getTeamItems().getItname() + "]]></name><xialimit>"
					+ u.getTeamItems().getItremark() + "</xialimit><limit>"
					+ u.getTeamItems().getItlimit() + "</limit><mcount>"
					+ memberCount + "</mcount>";
			if (memberCount >= Integer.parseInt(u.getTeamItems().getItremark())
					&& memberCount <= u.getTeamItems().getItlimit())
				res += "<mres>符合</mres>";
			else
				res += "<mres>不符</mres>";
			res += "<tealim>" + u.getTeamItems().getIttealim()
					+ "</tealim><teacap>" + u.getTeamItems().getItteacap()
					+ "</teacap><tcount>" + teaCount + "</tcount>";
			if (teaCount >= u.getTeamItems().getIttealim()
					&& teaCount <= u.getTeamItems().getItteacap())
				res += "<tres>符合</tres>";
			else
				res += "<tres>不符</tres>";
			res += "<state>";
			if (u.getAppstate() == -1)
				res += "审核未通过</state></unis>";
			else if (u.getAppstate() == 0)
				res += "待审核</state></unis>";
			else if (u.getAppstate() == 1)
				res += "审核通过</state></unis>";
		}
		res += "</allUniversities>";
		out.write(res);
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
