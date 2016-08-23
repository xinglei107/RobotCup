package com.robotcup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.robotcup.service.imp.TeamManageServiceImp;
import com.robotcup.util.MyTools;
import com.robotcup.util.SendMailUtil;

public class FindPwd extends HttpServlet {

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

		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String tname = request.getParameter("tname");
		String name = new String(tname.getBytes("ISO-8859-1"), "UTF-8");

		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		TeamManageServiceImp teamManageServiceImp = (TeamManageServiceImp) wac
				.getBean("teamManageServiceImp");
		String email = teamManageServiceImp.getEmailByTname(name);
		if (email == null) {
			out.println("<script language='javascript' type='text/javascript'>");
			out.println("alert('没有找到该用户，请检查您的输入!');window.location.href='"
					+ request.getContextPath() + "/reLogin.do'");
			out.println("</script>");
			out.flush();
			out.close();
		} else {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";

			String newpwd = ((int) (Math.random() * 20000000) + 80000000) + "";// 随机产生一个8位数的新密码
			teamManageServiceImp.changeTeamPassword(teamManageServiceImp
					.getTeamUserByTname(name).getTid(), MyTools.MD5(newpwd));
			String content = "<p>您申请重置华北五省（市、自治区）大学生机器人大赛网站的密码，已将您的密码重置为</p><p>"
					+ newpwd
					+ "</p><p>请尽快登录网站修改该密码</p><p>"
					+ "<a href='"
					+ basePath + "reLogin.do'>点此登录</a>" + "</p>";
			SendMailUtil smu = new SendMailUtil();
			smu.send(email, content);

			out.println("<p>已将重置后的密码发到您的注册邮箱，请查收邮件，使用重置后的密码登录本站，并尽快修改密码！</p>");
			out.println("<a href='" + request.getContextPath()
					+ "/reLogin.do'>返回登录界面</a>");
			out.flush();
			out.close();
		}

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
