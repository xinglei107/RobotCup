package com.robotcup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamApplication;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUser;
import com.robotcup.service.imp.ExecuteQueryImp;
import com.robotcup.service.imp.TeamAdminServiceImp;
import com.robotcup.service.imp.TeamManageServiceImp;

/**
 * 2016-04-01 限制一个项目一个学校最多报四队
 * 
 * @author xl
 * 
 */
public class TeamApp extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");// 禁用缓存
		int itid = Integer.parseInt(request.getParameter("itid"));
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
		TeamAdminServiceImp teamAdminServiceImp = (TeamAdminServiceImp) wac
				.getBean("teamAdminServiceImp");
		String year = (new Date().getYear() + 1900) + "";
		int result = 1;
		int times = 0;

		boolean ent = teamAdminServiceImp.getEntrance();
		if(!ent){
			result = -2;//报名入口已经关闭
		}
		else if (teamManageServiceImp.existLeader(tid) == -1)// 如果没有领队
		{
			request.setAttribute("res", -1);// 没有领队
			result = -1;
		} else {
			if (!teamManageServiceImp.hasTeamApplication(tid, itid, year)) {
				TeamItems item = teamManageServiceImp.getIteamByItid(itid);
				// 20160401判断该项目该参赛队所在学校是否超过4对
				// 20160521舞蹈机器人不超过6队，机器人创意不超过3，其他不超过4
				String tname = item.getItname();
				times = teamManageServiceImp.getAppCountByUnIt(user
						.getTeamUnversity().getSname(), item.getItname(), ""
						+ Calendar.getInstance().get(Calendar.YEAR));
				boolean isApp = false;
				if (tname.trim().equals("舞蹈机器人比赛（个人组）")
						|| tname.trim().equals("舞蹈机器人比赛（团体组）")) {
					if (times < 6) {
						isApp = true;
					}
				} else if (tname.trim().equals("机器人创意设计赛")) {
					if (times < 3) {
						isApp = true;
					}
				} else {
					if (times < 4) {
						isApp = true;
					}
				}
				if (isApp) {
					TeamApplication teamapp = new TeamApplication();
					teamapp.setTeamItems(item);
					teamapp.setTeamUser(user);
					teamapp.setAppstate(0);
					teamapp.setAppyear(year);
					teamManageServiceImp.addTeamApplication(teamapp);
					request.setAttribute("res", 1);// 操作成功
					result = 1;
				} else {
					request.setAttribute("res", 4);// 超过数量限制了，不能再报了
					request.setAttribute("maxCount", times);// 超过数量限制了，不能再报了
					result = 4;
				}
				// if(teamManageServiceImp.getItlimitByItid(itid))
				// TeamUser user = teamManageServiceImp.getTeamUserByTid(tid);

			} else {
				request.setAttribute("res", 0);// 已报名该项目
				result = 0;
			}
		}
		int memberCount = 0, teaCount = 0;
		String members = "", teachers = "";
		List<TeamApplication> applist = teamManageServiceImp.getItemsByTid(tid,
				year);
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
		String res = "<allUniversities><result>" + result + "</result><times>"
				+ times + "</times>";

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

		doGet(request, response);
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
