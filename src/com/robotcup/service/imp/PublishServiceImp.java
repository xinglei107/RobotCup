package com.robotcup.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.robotcup.domain.RobotAttachment;
import com.robotcup.domain.RobotLetter;
import com.robotcup.domain.RobotNews;
import com.robotcup.pojo.Attachment;
import com.robotcup.pojo.NewsImp;
import com.robotcup.service.inter.PublishServiceInter;
import com.robotcup.util.HibernateHelper;
@Controller
public class PublishServiceImp implements PublishServiceInter {

	@Resource
	private HibernateHelper hibernateHelper;
	public HibernateHelper getHibernateHelper() {
		return hibernateHelper;
	}
	public void setHibernateHelper(HibernateHelper hibernateHelper) {
		this.hibernateHelper = hibernateHelper;
	}
	/**
	 * 添加一条新闻
	 */
	@Override
	public void addNews(RobotNews news) {
		// TODO Auto-generated method stub
		hibernateHelper.save(news);
	}
	/**
	 * 获取某一模块下的全部新闻
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RobotNews> getTenNewsByAtid(int atid) {
		// TODO Auto-generated method stub
		String hql="from RobotNews where robotAttachment.atid=? order by mtop asc,mdate desc";
		return hibernateHelper.executeQuery(hql, new String[]{atid+""});
	}
	/**
	 * 根据新闻编号获取新闻
	 */
	@Override
	public RobotNews getNewsByNid(int nid) {
		// TODO Auto-generated method stub
		String hql="from RobotNews where nid=?";
		List list= hibernateHelper.executeQuery(hql, new String[]{nid+""});
		if(list.size()>0)
			return (RobotNews)list.get(0);
		return null;
	}
	/**
	 * 根据模块编号获取模块
	 */
	@Override
	public RobotAttachment getRoboAttachmentByAtid(int atid) {
		// TODO Auto-generated method stub
		String hql="from RobotAttachment where atid=?";
		List list=hibernateHelper.executeQuery(hql,new String[]{atid+""});
		if(list.size()>0)
			return (RobotAttachment) list.get(0);
		return null;
	}
	/**
	 * 带分页的获取附件信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> getAttachments(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		//不能取首页展示中的附件图片
		String hql="select mattachment,matname,mtop,mdate from RobotNews where atid!=10 and mattachment is not null order by mtop,mdate desc";
		List<Object[]> olist=hibernateHelper.executeQuery(hql,null,pageNum,pageSize);
		List<Attachment> res=new ArrayList<Attachment>();
		for(int i=0;i<olist.size();++i)
		{
			Attachment a=new Attachment();
			a.setName(olist.get(i)[0].toString());
			a.setRelname(olist.get(i)[1].toString());
			if(olist.get(i)[2]!=null)
				a.setTop(Integer.parseInt(olist.get(i)[2].toString()));
			a.setDate((Date)olist.get(i)[3]);
			res.add(a);
		}
		return res;
	}
	/**
	 * 带分页的获取某一模块下的新闻列表
	 */
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<NewsImp> getNewsByAtid(int atid,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select nid,mtop,mtitle,mdate from RobotNews where robotAttachment.atid=? order by mtop asc,mdate desc";
		String parameters[]=new String[]{atid+""};
		List<Object[]> list=hibernateHelper.executeQuery(hql, parameters,pageNum,pageSize);
		List<NewsImp> res=new ArrayList<NewsImp>();
		for(int i=0;i<list.size();++i){
			NewsImp ni=new NewsImp();
			ni.setNid(Integer.parseInt(list.get(i)[0].toString()));
			if(list.get(i)[1]!=null)
				ni.setMtop(Integer.parseInt(list.get(i)[1].toString()));
			ni.setTitle(list.get(i)[2].toString());
			ni.setMdate((Date)list.get(i)[3]);
			res.add(ni);
		}
		return res;
	}
	/**
	 * 获取某一模块下的新闻总数
	 * atid=9表示获取附件数目
	 * atid=0表示获取全部模块的新闻数目
	 */
	@Override
	public int getPageSumByAtid(int atid, int pageSize) {
		// TODO Auto-generated method stub
		//由于附件不是单独的模块，要单独处理
		String hql=null;
		Long o=null;
		if(atid!=9&&atid!=0)
		{
			hql="select count(*) from RobotNews where atid=?";
			o=(Long) hibernateHelper.executeQuery(hql,new String[]{atid+""}).get(0);
		}
		else if(atid==9)
		{
			hql="select count(*) from RobotNews where mattachment is not null and atid!=10";
			o=(Long) hibernateHelper.executeQuery(hql).get(0);
		}
		else if(atid==0)
		{
			hql="select count(*) from RobotNews where atid!=10";
			o=(Long) hibernateHelper.executeQuery(hql).get(0);
		}
		int pageSum=1;
		if(o!=null)
		{
			int count=Integer.parseInt(o.toString());
			pageSum=count%pageSize==0?count/pageSize:(count/pageSize+1);
		}
		return pageSum;
	}
	/**
	 * 返回全部的消息
	 * 不包括首页展示的图片
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NewsImp> getAllRobotNews(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select nid,mtop,mtitle,mdate,robotAttachment.atname,teamAdmin.adname from RobotNews where robotAttachment.atid!=10 order by mtop asc,robotAttachment.atname,teamAdmin.adname,mdate desc";
		List<Object[]> list=hibernateHelper.executeQuery(hql,null,pageNum,pageSize);
		List<NewsImp> res=new ArrayList<NewsImp>();
		for(int i=0;i<list.size();++i)
		{
			NewsImp ni=new NewsImp();
			ni.setNid(Integer.parseInt(list.get(i)[0].toString()));
			if(list.get(i)[1]!=null)
				ni.setMtop(Integer.parseInt(list.get(i)[1].toString()));
			ni.setTitle(list.get(i)[2].toString());
			ni.setMdate((Date) list.get(i)[3]);
			ni.setAttachment(list.get(i)[4].toString());
			ni.setAuthor(list.get(i)[5].toString());
			res.add(ni);
		}
		return res;
	}
	@Override
	public void delRobotNewsByNid(int nid) {
		// TODO Auto-generated method stub
		String hql="delete from RobotNews where nid=?";
		hibernateHelper.updateQuery(hql,new String[]{nid+""});
	}
	@Override
	public void updateNews(RobotNews news) {
		// TODO Auto-generated method stub
		hibernateHelper.updateQuery(news);
	}
	@Override
	public void addLetter(RobotLetter rl) {
		// TODO Auto-generated method stub
		hibernateHelper.save(rl);
	}
}
