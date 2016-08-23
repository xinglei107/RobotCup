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
			out.println("alert('û���ҵ����û���������������!');window.location.href='"
					+ request.getContextPath() + "/reLogin.do'");
			out.println("</script>");
			out.flush();
			out.close();
		} else {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";

			String newpwd = ((int) (Math.random() * 20000000) + 80000000) + "";// �������һ��8λ����������
			teamManageServiceImp.changeTeamPassword(teamManageServiceImp
					.getTeamUserByTname(name).getTid(), MyTools.MD5(newpwd));
			String content = "<p>���������û�����ʡ���С�����������ѧ�������˴�����վ�����룬�ѽ�������������Ϊ</p><p>"
					+ newpwd
					+ "</p><p>�뾡���¼��վ�޸ĸ�����</p><p>"
					+ "<a href='"
					+ basePath + "reLogin.do'>��˵�¼</a>" + "</p>";
			SendMailUtil smu = new SendMailUtil();
			smu.send(email, content);

			out.println("<p>�ѽ����ú�����뷢������ע�����䣬������ʼ���ʹ�����ú�������¼��վ���������޸����룡</p>");
			out.println("<a href='" + request.getContextPath()
					+ "/reLogin.do'>���ص�¼����</a>");
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
