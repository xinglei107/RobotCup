/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamItems;
import com.robotcup.domain.TeamUnversity;
import com.robotcup.parameter.Parameters;
import com.robotcup.pojo.NewsImp;
import com.robotcup.pojo.TeamApp;
import com.robotcup.service.imp.ExecuteQueryImp;
import com.robotcup.service.imp.PublishServiceImp;

/** 
 * MyEclipse Struts
 * Creation date: 03-22-2014
 * 
 * XDoclet definition:
 * @struts.action parameter="flag"
 */
@Controller
public class JustJumpAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	@Resource
	private ExecuteQueryImp executeQueryImp;
	public ExecuteQueryImp getExecuteQueryImp() {
		return executeQueryImp;
	}
	public void setExecuteQueryImp(ExecuteQueryImp executeQueryImp) {
		this.executeQueryImp = executeQueryImp;
	}
	@Resource
	private PublishServiceImp publishServiceImp;
	public PublishServiceImp getPublishServiceImp() {
		return publishServiceImp;
	}
	public void setPublishServiceImp(PublishServiceImp publishServiceImp) {
		this.publishServiceImp = publishServiceImp;
	}
	public ActionForward baseinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return mapping.findForward("baseinfo");
	}
	public ActionForward changepwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return mapping.findForward("changepwd");
	}
	public ActionForward letterlist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RobotLetter rl=executeQueryImp.getRobotLetter();
		request.getSession().setAttribute("rletter", rl);
		return mapping.findForward("lettershow");
	}
	public ActionForward publish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<RobotAttachment> attachment=executeQueryImp.getAllAttachment();
		attachment.remove(attachment.size()-1);//去掉首页展示
		attachment.remove(attachment.size()-1);//去掉附件下载
		request.getSession().setAttribute("attlist", attachment);
		return mapping.findForward("publish");
	}
	public ActionForward managenews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		List<NewsImp> allnewslist=publishServiceImp.getAllRobotNews(1,Parameters.NEWSPAGESIZE);
		request.getSession().setAttribute("allnews", allnewslist);
		
		int pageSum=publishServiceImp.getPageSumByAtid(0, Parameters.NEWSPAGESIZE);
		request.getSession().setAttribute("pageSum", pageSum==0?1:pageSum);
		request.getSession().setAttribute("pageNum", 1);
		return mapping.findForward("managenews");
	}
	public ActionForward adchpwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		return mapping.findForward("adminchangepwd");
	}
	public ActionForward uai(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		return mapping.findForward("uai");
	}
}