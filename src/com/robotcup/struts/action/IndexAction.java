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
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import com.robotcup.domain.RobotNews;
import com.robotcup.pojo.Attachment;
import com.robotcup.pojo.NewsImp;
import com.robotcup.service.imp.PublishServiceImp;
import com.robotcup.util.MyTools;

/** 
 * MyEclipse Struts
 * Creation date: 04-29-2014
 * 
 * XDoclet definition:
 * @struts.action
 */
@Controller
public class IndexAction extends Action {
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
	private PublishServiceImp publishServiceImp;
	public PublishServiceImp getPublishServiceImp() {
		return publishServiceImp;
	}
	public void setPublishServiceImp(PublishServiceImp publishServiceImp) {
		this.publishServiceImp = publishServiceImp;
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		//新闻，因为要显示预览图片和文字，所以与下面的处理方式不太一样
		List<RobotNews> news=publishServiceImp.getTenNewsByAtid(1);
		List<NewsImp> niList=new ArrayList<NewsImp>();
		for(int i=0;i<news.size()&&i<3;++i)//首页显示的要闻，最多三条
		{
			NewsImp ni=new NewsImp();
			ni.setImageUrl(MyTools.getImageUrl(news.get(i).getMcontent()));
			ni.setMdate(news.get(i).getMdate());
			if(news.get(i).getMtop()!=null)
				ni.setMtop(news.get(i).getMtop());
			ni.setNid(news.get(i).getNid());
			ni.setTitle(news.get(i).getMtitle());
			int length=ni.getTitle().length()>15?50:65;
			ni.setPreContent(MyTools.getText(news.get(i).getMcontent(), length));
			niList.add(ni);
		}
		request.getSession().setAttribute("newsimp", niList);
		
		//新闻动态部分，除了新闻中的三条以外的其他动态
		if(news.size()>0)
		{
			List<NewsImp> dtList=new ArrayList<NewsImp>();
			for(int i=0;i<10&&i<news.size();++i)//最多显示七条
			{
				NewsImp ni=new NewsImp();
				ni.setMdate(news.get(i).getMdate());
				if(news.get(i).getMtop()!=null)
					ni.setMtop(news.get(i).getMtop());
				ni.setNid(news.get(i).getNid());
				ni.setTitle(news.get(i).getMtitle());
				dtList.add(ni);
			}
			request.getSession().setAttribute("newslist", dtList);
		}
		else//防止删除新闻后session中还残留信息
			request.getSession().setAttribute("newslist", null);
		//参赛队风采
		List<RobotNews> inlist=publishServiceImp.getTenNewsByAtid(2);
		List<NewsImp> introList=new ArrayList<NewsImp>();
		for(int i=0;i<20&&i<inlist.size();++i)
		{
			NewsImp ni=new NewsImp();
			ni.setImageUrl(MyTools.getImageUrl(inlist.get(i).getMcontent()));
			ni.setNid(inlist.get(i).getNid());
			ni.setTitle(inlist.get(i).getMtitle());
			introList.add(ni);
		}
		request.getSession().setAttribute("introList", introList);
		
		//竞赛规则
		List<NewsImp> rulelist=publishServiceImp.getNewsByAtid(3, 1, 7);
		request.getSession().setAttribute("rule", rulelist);
		
		//比赛日程
		List<NewsImp> schedulelist=publishServiceImp.getNewsByAtid(4, 1, 7);
		request.getSession().setAttribute("schedule", schedulelist);
		
		//大赛介绍，只取第一篇
		List<RobotNews> intro=publishServiceImp.getTenNewsByAtid(7);
		if(intro.size()>0)
		{
			NewsImp ni=new NewsImp();
			ni.setImageUrl(MyTools.getImageUrl(intro.get(0).getMcontent()));
			ni.setMdate(intro.get(0).getMdate());
			if(intro.get(0).getMtop()!=null)
				ni.setMtop(intro.get(0).getMtop());
			ni.setNid(intro.get(0).getNid());
			ni.setTitle(intro.get(0).getMtitle());
			ni.setPreContent(MyTools.getText(intro.get(0).getMcontent(), 300));
			request.getSession().setAttribute("robotintro", ni);
		}
		else
			request.getSession().setAttribute("robotintro", null);

		//附件列表
		List<Attachment> alist=publishServiceImp.getAttachments(1,7);//最多取前七条数据
		request.getSession().setAttribute("attlist", alist);
		
		//首页大图

		List<RobotNews> imglist=publishServiceImp.getTenNewsByAtid(10);//获取首页展示的图片
		request.getSession().setAttribute("imglist", imglist);
		
		return mapping.findForward("index");
	}
}