/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.robotcup.struts.action;

import java.util.ArrayList;
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
import com.robotcup.parameter.Parameters;
import com.robotcup.pojo.Attachment;
import com.robotcup.pojo.NewsImp;
import com.robotcup.service.imp.ExecuteQueryImp;
import com.robotcup.service.imp.PublishServiceImp;

/** 
 * MyEclipse Struts
 * Creation date: 04-23-2014
 * 
 * XDoclet definition:
 * @struts.action parameter="method"
 */
@Controller
public class MoreAction extends DispatchAction {
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
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pageNum_=request.getParameter("pageNum");
		//默认显示第一页
		int pageNum=1,pageSum=1;
		if(pageNum_!=null)
			pageNum=Integer.parseInt(pageNum_);
		//获取要显示的菜单栏信息
		int atid=Integer.parseInt(request.getParameter("atid"));
		pageSum=publishServiceImp.getPageSumByAtid(atid, Parameters.NEWSPAGESIZE);
		List<RobotAttachment> ral=executeQueryImp.getAllAttachment();
		if(atid==1||atid==2||atid==4||atid==9)//下载，新闻动态，比赛日程，参赛队风采放在一起
		{
			List<RobotAttachment> menu=new ArrayList<RobotAttachment>();
			menu.add(ral.get(0));
			menu.add(ral.get(1));
			menu.add(ral.get(3));
			menu.add(ral.get(8));
			request.getSession().setAttribute("menu", menu);
		}
		else if(atid==3||atid==5||atid==6||atid==7||atid==8)//其他放在一起
		{
			List<RobotAttachment> menu=new ArrayList<RobotAttachment>();
			menu.add(ral.get(2));
			menu.add(ral.get(4));
			menu.add(ral.get(5));
			menu.add(ral.get(6));
			menu.add(ral.get(7));
			request.getSession().setAttribute("menu", menu);
		}
		request.getSession().setAttribute("pageNum", pageNum);
		request.getSession().setAttribute("pageSum", pageSum);
		request.getSession().setAttribute("cat", atid);
		//获取要显示的文章列表
		if(atid!=9)//不是附件下载
		{
			List<NewsImp> news=publishServiceImp.getNewsByAtid(atid, pageNum,Parameters.NEWSPAGESIZE);//，每页15条
			request.getSession().setAttribute("artlist", news);
			return mapping.findForward("showlist");
		}
		else//附件下载和其他列表的类型不同
		{
			List<Attachment> atts=publishServiceImp.getAttachments(pageNum,Parameters.NEWSPAGESIZE);
			request.getSession().setAttribute("attslist", atts);
			return mapping.findForward("attslist");
		}
	}
	public ActionForward next(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}