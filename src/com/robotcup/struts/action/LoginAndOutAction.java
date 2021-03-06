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

import com.robotcup.domain.TeamAdmin;
import com.robotcup.domain.TeamArea;
import com.robotcup.domain.TeamUser;
import com.robotcup.parameter.Parameters;
import com.robotcup.pojo.TeamInfo;
import com.robotcup.service.imp.ExecuteQueryImp;
import com.robotcup.service.imp.TeamAdminServiceImp;
import com.robotcup.service.imp.TeamManageServiceImp;
import com.robotcup.struts.form.TeamUserForm;
import com.robotcup.util.MyTools;

/** 
 * MyEclipse Struts
 * Creation date: 03-30-2014
 * 
 * XDoclet definition:
 * @struts.action parameter="method" validate="true"
 */
@Controller
public class LoginAndOutAction extends DispatchAction {
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
	@Resource
	private ExecuteQueryImp executeQueryImp;
	public ExecuteQueryImp getExecuteQueryImp() {
		return executeQueryImp;
	}
	@Resource
	private TeamAdminServiceImp teamAdminServiceImp;

	public TeamAdminServiceImp getTeamAdminServiceImp() {
		return teamAdminServiceImp;
	}

	public void setTeamAdminServiceImp(TeamAdminServiceImp teamAdminServiceImp) {
		this.teamAdminServiceImp = teamAdminServiceImp;
	}
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		TeamUserForm teamUserForm=(TeamUserForm)form;
		int lrole=teamUserForm.getLrole();//获取登录者身份
		String name=teamUserForm.getTname();
		String pwd=MyTools.MD5(teamUserForm.getTpwd());//密码加密后比较
		Object o=request.getSession().getAttribute("isCheckCode");
		String isCheckCode="";
		if(o!=null)
			isCheckCode=request.getSession().getAttribute("isCheckCode").toString();
		String ckc=request.getParameter("ckc");//获取用户输入的验证码
		String checkcode=(String) request.getSession().getAttribute("checkcode");//获取session中的验证码
		if(isCheckCode!=null&&isCheckCode.equals("1"))
		{
			if(ckc!=null&&!ckc.toUpperCase().equals(checkcode.toUpperCase()))//验证码输入不正确
			{
				request.getSession().setAttribute("teamUserForm", teamUserForm);//登录失败时保留用户已经输入的数据
				request.setAttribute("failcode", 1);//表示验证码错误
				request.setAttribute("showcode",1);
				request.getSession().setAttribute("isCheckCode", 1);
				return mapping.findForward("fail");
			}
		}
		if(lrole==0)//0代表参赛队
		{
			TeamUser teamUser= teamManageServiceImp.login(name, pwd);
			if(teamUser!=null)//登陆成功
			{
				request.getSession().setAttribute("teamuser", teamUser);
				return mapping.findForward("success");
			}
		}
		else if(lrole==1)//1代表管理员
		{
			TeamAdmin teamAdmin=teamManageServiceImp.adminLogin(name, pwd);
			if(teamAdmin!=null)//登陆成功
			{
				request.getSession().setAttribute("teamadmin", teamAdmin);

				List<TeamArea> alist=executeQueryImp.getArea();
				request.getSession().setAttribute("alist", alist);
				
//				List<TeamInfo> list=executeQueryImp.getTeamInfoByAid(teamAdmin.getTeamArea().getAid(),1,Parameters.APPPAGESIZE);
//				request.getSession().setAttribute("teamInfo", list);
//				request.getSession().setAttribute("pageNum", 1);
//				request.getSession().setAttribute("pageSum", executeQueryImp.getTeamPageSum(teamAdmin.getTeamArea().getAid(),Parameters.APPPAGESIZE));
				return mapping.findForward("area");
			}
		}
		//登录失败
		request.getSession().setAttribute("teamUserForm", teamUserForm);//登录失败时保留用户已经输入的数据
		request.setAttribute("fail", -1);//表示用户名或密码错误
		request.getSession().setAttribute("isCheckCode", 1);//表示下次登录时要验证验证码
		request.setAttribute("showcode",1);//表示要显示验证码界面
		return mapping.findForward("fail");
	}
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("teamuser");
		request.getSession().removeAttribute("teamadmin");//清空session信息
		return mapping.findForward("logout");
	}
}