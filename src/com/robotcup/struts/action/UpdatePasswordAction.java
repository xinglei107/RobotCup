/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import com.robotcup.service.imp.TeamManageServiceImp;
import com.robotcup.util.MyTools;

/** 
 * MyEclipse Struts
 * Creation date: 04-16-2014
 * 
 * XDoclet definition:
 * @struts.action
 */
@Controller
public class UpdatePasswordAction extends Action {
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
	private TeamManageServiceImp teamManageServiceImp;
	public TeamManageServiceImp getTeamManageServiceImp() {
		return teamManageServiceImp;
	}
	public void setTeamManageServiceImp(TeamManageServiceImp teamManageServiceImp) {
		this.teamManageServiceImp = teamManageServiceImp;
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(request.getParameter("tid"));
		String oldpwd=MyTools.MD5(request.getParameter("oldpwd"));
		String newpwd=MyTools.MD5(request.getParameter("newpwd"));
		if(oldpwd.equals(teamManageServiceImp.getTeamPassword(tid)))
		{
			teamManageServiceImp.changeTeamPassword(tid, newpwd);
			request.setAttribute("oldpwderr", 1);
			request.getSession().invalidate();//修改成功，重新登录，清空session信息
			return mapping.findForward("success");
		}
		else 
		{
			request.setAttribute("oldpwderr", 0);
			return mapping.findForward("fail");
		}
	}
}